/*
    DML : INSERT, UPDATE, DELETE 문장
        - 쿼리를 실행했을 때 실제 데이터가 변경된다.
        - 일반적으로 DML 작업을 할 때 TRANSACTION을 함께 사용하는 것을 권장한다.
*/
--INSERT 문장
INSERT INTO 테이블이름(컬럼명,...)VALUES (값, 값, ...);
INSERT INTO 테이블이름 VALUES (값, 값,...); --모든 컬럼에 순서대로 값을 설정
--UPDATE 문장
UPDATE 테이블 이름
SET 컬럼명=변경값, 컬럼명=변경값, ...
[WHERE 조건식];
--DELETE 문장
DELETE [FROM] 테이블 이름
[WHERE 조건식];
* TRUNCATE TABLE 테이블이름 ; --모든 레코드를 잘라내기 (삭제) -ROLLBACK이 안됨;
   : DML 문장이라고 읽지 않는다.
 
----------------------------------------------------------------------------------
--SCORR계정의 EMP 테이블을 복사해서 DML 연습하기
/*
   테이블 복사
   CREATE TABLE 테이블이름
*/

EX) 테이블 복사
CREATE TABLE COPY_EMP AS SELECT * FROM EMP;
 
--복사한 테이블 검색
SELECT * FROM COPY_EMP;

--복사를 하면 제약조건은 보존되지 않는다.
ALTER TABLE COPY_EMP ADD CONSTRAINT COPY_EMP_EMPNO_KEY PRIMARY KEY(EMPNO);

--원하는 레코드와 원하는 컬럼만 복사하기
CREATE TABLE COPY_EMP2 AS SELECT EMPNO, ENAME, JOB, SAL FROM EMP
WHERE SAL >= 3000;
SELECT * FROM COPY_EMP2;

--테이블의 구조만 복사하기 (레코드는 복사 안함)
 CREATE TABLE COPY_EMP3
 AS SELECT * FROM EMP WHERE 1=0;
 SELECT * FROM COPY_EMP3;


 
----------------------------------------------------------------------------------

SELECT * FROM COPY_EMP;

--등록(레코드를 두 개 추가하세요)
1) 모든 컬럼에 데이터를 넣는다.
INSERT INTO COPY_EMP VALUES(1218, 'DREW', 'PRESIDENT', 8000, '22/05/20', 7400, 500, 10);
2) EMPNO, ENAME, JOB, SAL,HIREDATE에 값을 넣는다. (HIREDATE ; 오늘날짜)
INSERT INTO COPY_EMP (EMPNO, ENAME, JOB, SAL, HIREDATE) VALUES (3203, 'NICKY', 'MANAGER', 4900, SYSDATE);

--수정
1) EMPNO가 7521인 사원의 JOB을 백수, HIREDATE를 오늘 날짜로 변경한다. 
UPDATE COPY_EMP SET JOB='백수', HIREDATE=SYSDATE WHERE EMPNO=7521;
2) DEPTNO가 30이면서 SAL가 2000 이상인 사원의 ENAME을 장동건, JOB은 연예인, HIREDATE는 2018-10-20 으로 변경한다.
UPDATE COPY_EMP SET ENAME ='장동건', JOB='연예인', HIREDATE='2018-10-20' WHERE DEPTNO=30 AND SAL>=2000;

--삭제
1) EMPNO가 7499인 데이터를 삭제한다.
DELETE COPY_EMP WHERE EMPNO=7499;
2) ENAME이 JONES 인 사원을 삭제한다.
DELETE COPY_EMP WHERE UPPER(ENAME)= UPPER('jONES');
3) DEPTNO가 20인 사원을 삭제한다.
DELETE COPY_EMP WHERE DEPTNO=20;

-- 대소문자 변환 (사용자 입력값과 데이터베이스 값을 비교하기 위해 한쪽으로 맞추어준다.)
-- UPPER(문자열) - 모두 대문자 / LOWER(문자열) - 모두 소문자
SELECT ENAME, UPPER(ENAME), LOWER(ENAME) FROM COPY_EMP;
COMMIT; --저장완료
ROLLBACK;
SELECT * FROM COPY_EMP;
   
* TRUNCATE TABLE COPY_EMP; --모든 레코드 삭제

----------------------------------------------------------------------------------
--레코드 검색
/*                                                                실행 순서
   SELECT DISTINCT | * | 컬럼명 AS 별칭 , 컬럼명 별칭, ...                3)
   FROM 테이블이름                                                     1)
   [WHERE 조건식]                                                     2)
   [ORDER BY 정렬 대상 컬럼 ASC | DESC, 정렬 대상 컬럼 ASC | DESC ...]     4) ; 정렬은 가장 마지막에 일어난다.
*/
   
EX) 컬럼에 별칭 주기T
SELECT EMPNO AS 사원번호, ENAME 이름, JOB , MGR "관리자 번호", HIREDATE --컬럼의 개수(열 제한)
FROM EMP;

EX) 중복행 제거 - DISTINCT
--사원들의 업무(JOB) 종류를 알고싶다.
SELECT DISTINCT JOB FROM EMP; 
--사원들의 부서 번호를 알고 싶다.
SELECT DISTINCT DEPTNO FROM EMP ORDER BY DEPTNO ASC;
EX) 정렬하기
   1) 급여를 기준으로 올림차순
   SELECT * FROM EMP ORDER BY SAL;
   2) 부서번호를 기준으로 내림차순을 하고 같은 부서는 급여가 낮은 사람먼저
   SELECT * FROM EMP ORDER BY DEPTNO DESC, SAL;
----------------------------------------------------------------------------------
--조건 만들기
/*
   1) OR
   2) AND
   3) 컬럼명 IN (값,값,...) - 하나의 컬럼에 여러개의 값을 OR로 검색할 때 쓰면 편리하다.
   4) 컬럼명 BETWEEN 최소 AND 최대 - 하나의 컬럼을 기준으로 최소~최대의 범위로 검색할 때
   5) LIKE => 같다 - 문자열을 검색할 때 사용
      : 와일드 카드 문자와 함께 사용한다.
         _ : 한글자 검색
         % : 0개 이상의 글자를 검색
      EX) 컬럼명 LIKE 'J%';      -- J로 시작하는 모든 문자열
      EX) 컬럼명 LIKE '%판교%';  -- 판교를 포함한 문자열
      EX) 컬럼명 LIKE '_b%';     -- 두번째 글자가 b인 문자열
      
   1)~5)의 반대로 표현하고 싶을 때는 NOT을 사용한다.
        EX) 컬럼명 NOT LIKE 'J%';
*/

EX) EMP 테이블에서 SAL가 2000~3000 사이인 데이터를 검색한다. (AND 이용) - SAL 기준 정렬
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<=3000 ORDER BY SAL; 

EX) EMP 테이블에서 SAL가 2000~3000 사이인 데이터를 검색한다. (BETWEEN AND 이용) - SAL 기준 정렬
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 3000 ORDER BY SAL; 
   
   * 위 두 문제의 반대 NOT을 해본다.
SELECT * FROM EMP WHERE NOT(SAL>=2000 AND SAL<=3000) ORDER BY SAL; 
SELECT * FROM EMP WHERE NOT(SAL BETWEEN 2000 AND 3000) ORDER BY SAL; 

EX) EMPNO가 7566, 7499, 7654 인 사원을 검색한다. (OR 이용)
SELECT * FROM EMP WHERE EMPNO=7566 OR EMPNO=7499 OR EMPNO=7654;

EX) EMPNO가 7566, 7499, 7654 인 사원을 검색한다. (IN 이용)
SELECT * FROM EMP WHERE EMPNO IN (7566, 7499, 7654);

   * 위 두 문제의 반대 NOT을 해본다.
SELECT * FROM EMP WHERE NOT(EMPNO=7566 OR EMPNO=7499 OR EMPNO=7654);
SELECT * FROM EMP WHERE NOT EMPNO IN (7566, 7499, 7654);
    
EX) JOB의 첫글자가 S로 시작하는 사원을 검색한다.
SELECT * FROM EMP WHERE JOB LIKE 'S%';

EX) ENAME의 a 글자가 포함되어 있으면서 JOB이 man으로 끝나는 사원을 검색한다.
SELECT * FROM EMP WHERE ENAME LIKE '%A%' AND JOB LIKE '%MAN';

EX) SAL가 2000이상이면서 JOB의 글자가 7글자인 사원을 검색한다.
SELECT * FROM EMP WHERE SAL>=2000 AND JOB LIKE '_______';

EX) DEPTNO가 20이거나 SAL이 3000보다 큰 사원을 검색한다.
SELECT * FROM EMP WHERE DEPTNO LIKE '20' OR SAL>=3000;

SELECT * FROM EMP;

----------------------------------------------------------------------------------
/*
   NULL 검색
   IS NULL
   IS NOT NULL
*/
CREATE TABLE COPY_EMP AS SELECT * FROM EMP; -- 복사

EX) COPY_EMP테이블에서 COMM이 NULL인 레코드의 JOB을 '학생', COMM을 100으로 변경
UPDATE COPY_EMP SET JOB = '학생' WHERE COMM IS NULL;
SELECT * FROM COPY_EMP;

EX) COPY_EMP에서 COMM이 NULL이 아닌 레코드를 삭제
DELETE COPY_EMP WHERE COMM IS NOT NULL;
SELECT * FROM COPY_EMP;

----------------------------------------------------------------------------------
/*
   ANY : 최소한 하나라도 만족하면 TRUE
      ex) 컬럼명 > ANY (100, 200, 300) - 최소값보다 크면 참
      ex) 컬럼명 < ANY (100, 200, 300) - 최대값보다 작으면 참

   ALL : 모두 만족해야 TRUE
      ex) 컬럼명 > ALL (100, 200, 300) - 최대값보다 크면 참
      ex) 컬럼명 < ALL (100, 200, 300) - 최소값보다 작으면 참
*/

SELECT * FROM EMP WHERE SAL > ANY (1000, 2000, 3000);
SELECT * FROM EMP WHERE SAL > ALL (1000, 2000, 3000);
SELECT * FROM EMP WHERE SAL < ANY (1000, 2000, 3000);
SELECT * FROM EMP WHERE SAL < ALL (1000, 2000, 3000);

EX) 부서가 10인 사원들의 급여보다 더 많이 받는 사원 검색.
SELECT * FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 20);

EX) 부서가 30인 사원들의 급여보다 더 적게 받는 사원 검색.
SELECT * FROM EMP WHERE SAL < ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);

/*
   집계함수
   SUM() - 합계
   MIN() - 최소값
   MAX() - 최대값
   AVG() - 평균 (NULL을 제외한 평균)
   COUNT() - NULL을 포함한 총 레코드 수
*/

-- 샘플데이터
CREATE TABLE SUNGJUK(
   NAME VARCHAR2(20),
   BAN NUMBER(1),
   KOR NUMBER(3),
   ENG NUMBER(3),
   MATH NUMBER(3)
);

INSERT INTO SUNGJUK VALUES('AAA', 1, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('BBB', 2, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('CCC', 3, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('DDD', 1, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), NULL);
INSERT INTO SUNGJUK VALUES('EEE', 2, DBMS_RANDOM.VALUE(1,100), NULL, DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('FFF', 3, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('GGG', 1, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('HHH', 2, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('III', 3, NULL, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('JJJ', 1, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('KKK', 2, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));
INSERT INTO SUNGJUK VALUES('LLL', 3, DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100), DBMS_RANDOM.VALUE(1,100));

EX) 각 개인별 총점, 평균을 구한다.
SELECT NAME, BAN, KOR, ENG, MATH, (NVL(KOR,0)+NVL(ENG,0)+NVL(MATH,0)) AS TOTAL, ROUND((NVL(KOR,0)+NVL(ENG,0)+NVL(MATH,0))/3, 2) AS AVG FROM SUNGJUK;

/*
   NVL(값, 변경값)
      : 값이 NULL이라면 변경값을 변경한다.
      : NULL값을 찾아서 다른값으로 변경
*/

EX) 국어점수 최대값, 최소값, 총점, 평균 구한다.
SELECT MAX(KOR), MIN(KOR), SUM(KOR), ROUND(AVG(KOR)), ROUND(AVG(NVL(KOR,0)),2) AS AVG, COUNT(KOR) AS COUNT, COUNT(*) FROM SUNGJUK;

EX) 일반컬럼과 집계함수를 같이 검색해본다.
SELECT NAME, MAX(KOR), MIN(KOR), SUM(KOR) FROM SUNGJUK; --오류..
   : dldb - 일반컬럼과 집계함수는 같은 SELECT절에 함께 사용할 수 없다.

EX) 각 반별 최대값, 최소값, 총점, 평균 구한다.
SELECT BAN, MAX(KOR), MIN(KOR), SUM(KOR), ROUND(AVG(KOR)), ROUND(AVG(NVL(KOR,0)),2), COUNT(KOR), COUNT(*)
FROM SUNGJUK
GROUP BY BAN; -- 집계함수를 이용할 때 그룹핑을 시켜 그룹내에서의 집계함수를 사용.

   * GROUP BY 절에 사용한 일반 컬럼은 SELECT 절에서 함께 사용가능하다.

EX) 국어점수가 70 이상인 학생들의 인원수, 총점, 평균.
SELECT COUNT(*), SUM(KOR), AVG(KOR) FROM SUNGJUK
WHERE KOR >= 70;

EX) 각 반별 국어 점수의 평균이 50 이상인 레코드 인원수, 총점, 평균 검색
SELECT COUNT(*), SUM(KOR), AVG(KOR)
FROM SUNGJUK
GROUP BY BAN -- 집계함수를 조건으로 사용할때는 HAVING 절을 이용한다. HAVING은 GROUP BY 절이 있을때 사용한다.
HAVING AVG(KOR) >= 50;

EX) EMP테이블에서 각 부서별 급여의 평균과 사원의 수 구한다.
SELECT COUNT(*), ROUND(AVG(SAL),2) FROM EMP;

EX) EMP테이블에서 각 부서별 급여의 평균과 사원의 수를 구하되 평균 급여가 2000 이상인 부서만 검색한다.
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL),2) FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) > 2000;

----------------------------------------------------------------------------------
/*
   --숫자함수
   ROUND(숫자):
   CEIL(숫자); -- 올림해서 정수
   FLOOR(숫자 ): -- 내림해서 정수
   TRUNC(숫자, 자릿수) -- 버림

   --문자열 함수
   UPPER(문자열) -- 모두 대문자
   LOWER(문자열) -- 모두 소문자
   INITCAP(문자열) -- 단어의 첫글자 대문자
   SUBSTR(문자열,시작위치) -- 시작위치부터 끝까지 문자열 일부분 추출
   SUBSTR(문자열,시작위치,개수) -- 시작위치부터 개수만큼 문자열 일부분 추출
   INSTR(문자열,'찾는문자') -- 문자열의 찾는 문자가 문자열 몇번지 있는지 index리턴
   INSTR(문자열,'찾는문자', 시작위치) -- 시작위치부터 문자열 몇번지 있는지 찾기, 만약 시작위치가 -1이면 오른쪽부터 찾는다.
   INSTR(문자열,'찾는문자', 시작위치, 몇번째 나왔는지)
   LENGTH() -- 문자열 길이

   RTRIM(), LTRIM()
   LPAD(), RPAD()
*/
-- DUAL: 오라클에서 제공하는 가상테이블.
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- 현재 날짜와 시간 검색
SELECT 38.57845, CEIL(38.57845), FLOOR(38.57845), TRUNC(38.57845,2) FROM DUAL;

-- 문자열 일부 추출하기
SELECT 'ABCD ABCD ABCD', LENGTH('ABCD ABCD ABCD') FROM DUAL;
SELECT 'ABCD ABCD ABCD', SUBSTR('ABCD ABCD ABCD',3), SUBSTR('ABCD ABCD ABCD',3,5) FROM DUAL;

-- 찾는 문자열 몇번지에 있는지 찾기
SELECT 'ABCD ABCD ABCD', INSTR('ABCD ABCD ABCD', 'B'), INSTR('ABCD ABCD ABCD', 'B', 3),
INSTR('ABCD ABCD ABCD', 'B', 3, -1), INSTR('ABCD ABCD ABCD', 'B', 3, -10)  FROM DUAL;
SELECT 'ABCD ABCD ABCD', INSTR('ABCD ABCD ABCD', 'B',1), INSTR('ABCD ABCD ABCD', 'B', 1,2) FROM DUAL;

SELECT 'ABCD ABCD ABCD', INSTR('ABCD ABCD ABCD', 'F') FROM DUAL; -- 찾는 문자가 없으면 0 나온다.

EX) EMP테이블에서 JOB의 세번째 글자가 'A'인 레코드 검색
1) LIKE
SELECT * FROM EMP WHERE JOB LIKE '__A%';
2) SUBSTR
SELECT * FROM EMP WHERE SUBSTR(JOB, 3, 3) = 'A';
3) INSTR
SELECT * FROM EMP WHERE INSTR(JOB, 'A', 3) = 3;

----------------------------------------------------------------------------------
-- TO_CHAR()
EX) EMP에서 HIREDATE가 1980년인 레코드 검색
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY') = '1980';

SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY'), TO_CHAR(HIREDATE, 'YYYY-MM'), TO_CHAR(HIREDATE, 'YYYY-MM-DD HH:MI:SS') FROM EMP; 

   * TO_CHAR(NUMBER, FORMAT)

SELECT SAL, TO_CHAR(SAL, '999,999'), TO_CHAR(SAL, '999,999') || '만원' FROM EMP;