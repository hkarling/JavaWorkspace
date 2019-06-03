/*
    날짜함수
    - SYSDATE : 현재 날짜
    - MONTHS_BETWEEN(DATE 1, DATE 2) : 두 날짜 사이의 개월 수의 차이를 구한다.
    - ADD_MONTH(DATE, NUMBER) : 날짜에서 숫자만큼 개월 수를 더한다.
    - NEXT_DAY(DATE, WEEK) : 날짜에서 가장 가까운 요일을 찾는다.
                        * 1 - 일요일, 2 - 월요일, ... , 7 - 토요일
    - LAST_DAY(DATE) : 날짜에 해당하는 달의 마지막 일 날짜를 구한다.
*/
SELECT SYSDATE, MONTHS_BETWEEN(SYSDATE, '2019-10-20') FROM DUAL;

--EX) 현재 달의 마지막 일
SELECT LAST_DAY(SYSDATE) FROM DUAL;

--EX) 오늘 날짜를 기준으로 가장 빠른 월요일 구하기
SELECT NEXT_DAY(SYSDATE, 2) FROM DUAL;

--EX) 우리가 만난지 100일은 언제?
SELECT TO_DATE('2019-04-29') + 100 FROM DUAL;

--EX) EMP테이블에서 입사일 기준으로 현재까지 근무개월수 구하기
SELECT HIREDATE, CEIL(MONTHS_BETWEEN(SYSDATE, HIREDATE)) || '개월' AS MONTHS FROM EMP;

--EX) ~님의 급여는 ~입니다.
SELECT ENAME || '님의 급여는 ' || SAL || '입니다' FROM EMP;

--------------------------------------------------------------------------------------------------- 

SELECT          -- 5) PROJECTION (열 제한 - COLUMN)
FROM            -- 1)   
[ WHERE ]       -- 2) SELECTION (행 제한 - ROW)
[ GROUP BY ]    -- 3)
[ HAVING ]      -- 4)
[ ORDER BY ]    -- 6)

--------------------------------------------------------------------------------------------------- 
/*
    SELECT 절에서 조건에 따라 다른 문장을 실행할때 사용하는 함수 2가지
    1) DECODE (대상, 값, 문장, 값, 문장, 값, 문장, ... , 문장)
    2) CASE [ 대상 ]
            WHEN 조건 THEN 문장
            WHEN 조건 THEN 문장
            ...
            ELSE STATEMENT
        END
*/

-- 성적테이블에서
SELECT * FROM SUNGJUK;

--EX) 반에 따라 반명을 부여한다.
SELECT NAME, BAN, DECODE(BAN, 1, '무엇', 2, '그것', 3, '저것') FROM SUNGJUK;
SELECT NAME, BAN, CASE BAN WHEN 1 THEN '어디' WHEN 2 THEN '저기' ELSE '거기' END FROM SUNGJUK;

--EX) 국어점수에 따른 등급 구하기
SELECT NAME, NVL(KOR,0) AS KOR, CASE WHEN NVL(KOR, 0) > 80 THEN PASS ELSE FAIL END AS OUTCOME FROM SUNGJUK;

--EX) EMP테이블에서 DEPNO가 10 이면 관리부, 20이면 총무부, 30이면 영업부 이외의 값은 기타부 로 출력하고 컬럼명은 부서명 으로 한다. (DECODE, CASE END)
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, '관리부', 20, '총무부', 30, '영업부', '기타부') AS 부서명 FROM EMP;
SELECT ENAME, DEPTNO, CASE DEPTNO WHEN 10 THEN '관리부' WHEN 20 THEN '총무부' WHEN 30 THEN '영업부' ELSE '기타부' END AS 부서명 FROM EMP;

--EX)JOB이 MANAGER인 경우 SAL*0.1, ANALYST 인경우는 SAL *0.2 SALESMAN인 경우는 SAL * 0.3을 구해서 성과급 필드를 만든다.(CASE END, DECODE 다 해본다) 
SELECT ENAME, JOB, SAL, DECODE(JOB, 'MANAGER', SAL*0.1, 'ANALYST', SAL * 0.2, 'SALESMAN', SAL * 0.3) AS 성과급 FROM EMP;
SELECT ENAME, JOB, SAL, CASE JOB WHEN 'MANAGER' THEN SAL*0.1 WHEN 'ANALYST' THEN SAL * 0.2 WHEN 'SALESMAN' THEN SAL * 0.3 END AS 성과급 FROM EMP;

--EX) SAL이 2000 이하이이면 '저소득층', 2001 ~ 4000 이면 '중산층', 4001 이상이면 '고소득층' 구하여 등급 별칭을 해준다. (CASE END)
SELECT ENAME, JOB, SAL, CASE WHEN SAL > 4001 THEN '고소득층' WHEN SAL > 2001 THEN '중산층' ELSE '저소득층' END AS 등급 FROM EMP;

---------------------------------------------------------------------------------------------------
/*
    JOIN : 여러개의 테이블로 수평으로 묶어서 한번에 SELECT로 여러개 테이블에서 있는 컬럼의 정보를 검색할 수 있다.
        
        * 종류
            1) INNER JOIN : 동등조인 = EQ조인
            2) OUTER JOIN : LEFT, RIGHT, FULL
            3) SELF JOIN

        * JOIN 코딩 방식
            1) SQL JOIN - (FULL JOIN 지원 안함.)
            2) ANSI JOIN - 권장
*/
-- 1) INNER JOIN: SQL JOIN
SELECT [COLUMN], [COLUMN], ... FROM [TABLE], [TABLE], ... WHERE [CONDITION] -- 조건식에 공통컬럼을 넣는다.
-- 2) INNER JOIN: ANSI JOIN
SELECT [COLUMN], [COLUMN], ... FROM [TABLE] [INNER] JOIN [TABLE] ON 조건식; -- USING(FOREIGN KEY) 두테이블에서의 이름이 같은경우.

-- EX) TABLE 만들기
CREATE TABLE TEST1 (
    ID VARCHAR2(3) PRIMARY KEY,
    NAME VARCHAR(20),
    ADDR VARCHAR(30)
);

INSERT INTO TEST1 VALUES ('1', 'AAAA', '서울');
INSERT INTO TEST1 VALUES ('2', 'BBBB', '대전');
INSERT INTO TEST1 VALUES ('3', 'CCCC', '대구');
INSERT INTO TEST1 VALUES ('4', 'DDDD', '부산');
INSERT INTO TEST1 VALUES ('5', 'EEEE', '광주');

CREATE TABLE TEST2(
    CODE CHAR(3) PRIMARY KEY,
    ID VARCHAR2(3) REFERENCES TEST1(ID),
    JOB VARCHAR2(10),
    SAL NUMBER(5)
)

INSERT INTO TEST2 VALUES ('A01', '1', '가가가', 50000);
INSERT INTO TEST2 VALUES ('A02', '3', '나나나', 80000);
INSERT INTO TEST2 VALUES ('A03', '5', '다다다', 3000);
INSERT INTO TEST2 VALUES ('A04', NULL, '라라라', 6000);

------------
-- INNER JOIN: SQL JOIN
SELECT * FROM TEST1, TEST2 WHERE TEST1.ID = TEST2.ID;
SELECT TEST1.ID, NAME, ADDR, JOB, SAL FROM TEST1, TEST2 WHERE TEST1.ID = TEST2.ID;
SELECT T1.ID, NAME, ADDR, JOB, SAL FROM TEST1 T1, TEST2 T2 WHERE T1.ID = T2.ID;

------------
-- INNER JOIN: ANSI JOIN
SELECT * FROM TEST1 T1 JOIN TEST2 T2 ON T1.ID = T2.ID;
SELECT * FROM TEST1 T1 JOIN TEST2 T2 USING(ID); -- USING 사용시 중복된다고 테이블명.컬럼명 쓰지마라.

-- OUTER LEFT JOIN
SELECT * FROM TEST1, TEST2 WHERE TEST1.ID = TEST2.ID(+);
SELECT * FROM TEST1 LEFT JOIN TEST2 USING(ID);

-- OUTER RIGHT JOIN
SELECT * FROM TEST1, TEST2 WHERE TEST1.ID(+) = TEST2.ID;
SELECT * FROM TEST1 RIGHT JOIN TEST2 USING(ID);

-- OUTER FULL JOIN: SQL JOIN 방법 밖에 없다.
SELECT * FROM TEST1 FULL JOIN TEST2 USING(ID);

CREATE TEST3(
    CODE CHAR(3) PRIMARY KEY REFERENCES TEST2(CODE),
    MANAGER_NAME VARCHAR2(20)
);

INSERT INTO TEST3 VALUES('A01', '1번매니저');
INSERT INTO TEST3 VALUES('A02', '2번매니저');

-- SQL JOIN
SELECT * FROM TEST1, TEST2, TEST3 WHERE TEST1.ID = TEST2.ID AND TEST2.CODE = TEST3.CODE;

-- ANSI JOIN
SELECT * FROM TEST1 JOIN TEST2 USING(ID) JOIN TEST3 USING(CODE);

---------------------------------------------------------------------------------------------------
/*
    SELF JOIN : 자기자신 테이블을 조인하는 것. 하나의 테이블을 두개인 것처럼 사용한다.
*/

SELECT * FROM EMP;

--EX) 어떤 사원의 직송상관이 누구인지 알고싶다.

SELECT E1.EMPNO AS 사원번호, E1.ENAME AS 사원이름, E2.EMPNO AS 상관사원번호, E2.ENAME AS 상관이름
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO(+);

---------------------------------------------------------------------------------------------------
-- 문제
---------------------------------------------------------------------------------------------------
-- 1. SMITH 에 대한  정보 검색(ename, emp.deptno, loc .)
SELECT ENAME, DEPTNO, LOC FROM EMP JOIN DEPT USING(DEPTNO)
WHERE ENAME = 'SMITH';

--2. NEW YORK에 근무하는 사원의 이름과 급여를 출력
SELECT ENAME, SAL FROM EMP JOIN DEPT USING (DEPTNO)
WHERE LOC = 'NEW YORK';

-- 3. ACCOUNTING 부서 소속 사원의 이름과 입사일 출력
SELECT ENAME, HIREDATE FROM EMP JOIN DEPT USING (DEPTNO)
WHERE DNAME = 'ACCOUNTING';

-- 4. 직급이 MANAGER인 사원의 이름, 부서명 출력
SELECT ENAME, DNAME FROM EMP JOIN DEPT USING (DEPTNO)
WHERE JOB = 'MANAGER';

-- 5. 사원의 급여가 몇 등급인지를 검색
SELECT EMP.*, GRADE FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL;

--6. 사원 테이블의 부서 번호로 부서 테이블을 참조해서 부서명, 급여 등급도 검색
SELECT EMP.*, DNAME, GRADE FROM EMP, DEPT, SALGRADE
WHERE EMP.DEPTNO = DEPT.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;

SELECT EMP.*, DNAME, GRADE FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO 
                                    JOIN SALGRADE ON SAL BETWEEN LOSAL AND HISAL;
                                    
--7. SMITH의 메니저(mgr) 이름(ename) 검색
SELECT E2.ENAME FROM EMP E1 JOIN EMP E2 ON E1.MGR = E2.EMPNO
WHERE E1.ENAME = 'SMITH';

--8. 관리자가 KING인 사원들의 이름과 직급(job) 검색
SELECT E1.ENAME, E1.JOB FROM EMP E1 JOIN EMP E2 ON E1.MGR = E2.EMPNO
WHERE E2.ENAME = 'KING';

--9. SMITH 와 동일한 부서번호(DEPTNO)에서 근무하는 사원의 이름 출력
-- 단, SMITH 데이터 절대 출력 불가
SELECT E2.ENAME FROM EMP E1, EMP E2
WHERE E1.DEPTNO = E2.DEPTNO AND E1.ENAME = 'SMITH' AND NOT E2.ENAME= 'SMITH';

--10. SMITH와 동일한 근무지(LOC)에서 근무하는 사원의 이름 출력
-- 단, SMITH 데이터 절대 출력 불가
SELECT E2.ENAME
FROM EMP E1, DEPT D1, DEPT D2, EMP E2
WHERE E1.DEPTNO = D1.DEPTNO AND D1.LOC = D2.LOC AND D2.DEPTNO = E2.DEPTNO AND E1.ENAME = 'SMITH' AND NOT E2.ENAME = 'SMITH';

SELECT E1.ENAME, D1.LOC, E2.ENAME 
FROM EMP E1 JOIN DEPT D1 ON (E1.DEPTNO = D1.DEPTNO)
            JOIN DEPT D2 ON (D1.LOC = D2.LOC)
            JOIN EMP E2 ON (D2.DEPTNO = E2.DEPTNO)
WHERE E1.ENAME = 'SMITH' AND NOT E2.ENAME = 'SMITH';

-- 11, 사원명, 해당 하는 메니저명 검색
-- 반드시 모든 사원들(CEO포함) 정보 검색
-- CEO인 경우 메니저 정보 null
SELECT E1.ENAME as 사원, E2.ENAME as 관리자 FROM EMP E1 LEFT JOIN EMP E2 ON (E1.MGR = E2.EMPNO);

---------------------------------------------------------------------------------------------------
/*
    SET 집합
    1) 합집합 
        - UNION : 중복행을 제거한 합집합
        - UNION ALL : 중복행을 포함한 합집합.
    2) 교집합 : 
    3) 차집합 : 
*/
-- 테이블 복사
CREATE TABLE SET_EMP AS SELECT * FROM EMP WHERE DEPTNO=20;

-- SET_EMP에 레코드 추가
INSERT INTO SET_EMP(EMPNO, ENAME, JOB, SAL) VALUES (9000, 'AAAA', '가가가', 3500);
INSERT INTO SET_EMP(EMPNO, ENAME, JOB, SAL) VALUES (9100, 'BBBB', '나나나', 4500);
INSERT INTO SET_EMP(EMPNO, ENAME, JOB, SAL) VALUES (9200, 'CCCC', '다다다', 6500);

-- 합집합
SELECT EMPNO, ENAME, JOB, SAL FROM EMP
UNION
SELECT EMPNO, ENAME, JOB, SAL FROM SET_EMP;

SELECT EMPNO, ENAME, JOB, SAL FROM EMP
UNION ALL
SELECT EMPNO, ENAME, JOB, SAL FROM SET_EMP;

---------------------------------------------------------------------------------------------------
---- 테스트
-- 각자의 계정으로 접속.
DROP TABLE EMP;

-- EMP 테이블 생성
CREATE TABLE EMP(
    EMP_ID NUMBER(4) PRIMARY KEY, -- 사원번호
    EMP_NAME VARCHAR2(30) NOT NULL, -- 사원이름
    JOB VARCHAR2(20) NOT NULL, -- 직업
    DEPT_ID NUMBER(3), -- 부서번호
    SAL NUMBER(5), -- 급여
    BONUS NUMBER(5), -- 보너스
    MGR_ID NUMBER(5), -- 관리자번호
    HIREDATE DATE NOT NULL -- 입사일
)

--데이터삽입
INSERT INTO EMP VALUES (6200,'박철수','대표이사',200,5000,NULL,NULL,'1997-12-17');
INSERT INTO EMP VALUES (6311,'김대정','부장',100,3500,NULL,6200,'1998-12-17');
INSERT INTO EMP VALUES (7489,'민동규','세일즈',400,1850,200,6321,'1999-02-27');
INSERT INTO EMP VALUES (7522,'정종철','세일즈',400,1850,300,6321,'1998-02-28');
INSERT INTO EMP VALUES (6321,'이종길','부장',400,3800,500,6200,'1999-04-20');
INSERT INTO EMP VALUES (6351,'진대준','부장',300,2850,NULL,6200,'2000-05-31');
INSERT INTO EMP VALUES (7910,'이영희','경리',300,1000,NULL,6351,'2001-05-01');
INSERT INTO EMP VALUES (6361,'김철수','부장',200,3200,NULL,6200,'2000-06-09');
INSERT INTO EMP VALUES (7878,'백기수','연구직',200,3000,NULL,6361,'2001-06-05');
INSERT INTO EMP VALUES (7854,'진영진','세일즈',400,1500,0,6321,'2001-09-08');
INSERT INTO EMP VALUES (7872,'이문정','사무직',100,1500,NULL,6311,'2001-02-12');
INSERT INTO EMP VALUES (7920,'김마리아','사무직',300,1050,NULL,6351,'2001-03-18');
INSERT INTO EMP VALUES (7901,'정동길','연구직',NULL,3000,NULL,NULL,'2001-12-03');
INSERT INTO EMP VALUES (7933,'김철수','사무직',200,1050,NULL,6361,'2002-01-02');

SELECT * FROM EMP;

-- 1 EMP 테이블에서 각사원의 EMP_NAME 의 급여(SAL)에 100을 더한 후 12를 곱한 값이 출력되도록 SELECT 절에 산술식을 사용해보시오. (별칭 - 년봉)
SELECT EMP_NAME, (SAL + 100) * 12 연봉 FROM EMP;

-- 2 담당업무 JOB 이 세일즈인 모든 사원의 이름과 담당업무, 부서번호를 검색하시오.
SELECT EMP_NAME, JOB, DEPT_ID FROM EMP WHERE JOB = '세일즈';

-- 3 입사일이 2001년 12월 3일인 모든 사원을 검색하시오.
SELECT * FROM EMP WHERE HIREDATE = TO_DATE('2001-12-03', 'YYYY-MM-DD');

-- 4 부서번호가 200인 부서에서 근무하는 모든 사원의 이름과 담당업무, 입사일, 부서번호를 검색하시오.
SELECT EMP_NAME, JOB, HIREDATE, DEPT_ID FROM EMP WHERE DEPT_ID = 200;

-- 5 급여가 3000이상 5000이하인 모든 사원의 이름과 급여를 출력하시오.
SELECT EMP_NAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 5000;

-- 6 관리자번호가 6311, 6361, 6351 가운데 하나인 모든 사원의 사원번호, 관리자번호, 이름, 부서번호를 출력하시오.
SELECT EMP_ID, MGR_ID, EMP_NAME, DEPT_ID FROM EMP WHERE MGR_ID IN (6311, 6361, 6351);

-- 7 담당업무가 사무직이거나 경리인 사원의 모든 정보를 검색하시오.
SELECT * FROM EMP WHERE JOB IN ('사무직', '경리');

-- 8 급여가 3000이상인 모든 부장의 정보를 검색하시오.
SELECT * FROM EMP WHERE JOB = '부장' AND SAL >= 3000;

-- 9 담당업무가 세일즈이거나 사무직이 아닌 모든 사원의 정보를 검색하시오.
SELECT * FROM EMP WHERE JOB NOT IN ('세일즈', '사무직');

-- 10 급여가 1500 이상 2500 이하가 아닌 모든 사원의 정보를 검색하시오.
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 2500;

-- 11 담당업무가 경리이거나 부장이면서 급여가 3000 이 넘는 모든 사원의 정보를 검색하고 가장 먼저 입사한 사람부터 출력하시오.
SELECT * FROM EMP WHERE JOB IN ('경리', '부장') AND SAL > 3000 ORDER BY HIREDATE;

-- 12 사원의 부서번호를 기준으로 오름차순정렬, 같은 부서안에서는 급여가 많은 사람이 먼저 출력되도록 하라.
SELECT * FROM EMP ORDER BY DEPT_ID, SAL DESC;

-- 13 보너스가 NULL이 아니면서 입사일이 2000년 이상인 사원의 정보를 검색하시오.
SELECT * FROM EMP WHERE BONUS IS NOT NULL AND HIREDATE >= TO_DATE('2000', 'YYYY');

-- 14 이름이 3글자이고 끝글자가 '수'이며 첫글자는 '박'으로 시작하는 사원의 정보를 검색하시오.
SELECT * FROM EMP WHERE EMP_NAME LIKE '박_수';

-- 15 보너스가 NULL인 사원의 보너스를 0으로 변경하시오.
UPDATE EMP SET BONUS = 0 WHERE BONUS IS NULL;

-- 16 직업이 '직'으로 끝나면서 급여가 2000~3000 사이인 사원의 이름을 '장동건', 급여를 3500으로 변경하시오.
UPDATE EMP SET EMP_NAME = '장동건', SAL = 3500 WHERE JOB LIKE '%직' AND SAL BETWEEN 2000 AND 3000;

-- 17 이름에 '철'자가 들어가면서 직급이 부장인 사원의 정보를 삭제하시오.
DELETE EMP WHERE EMP_NAME LIKE '%철%' AND JOB = '부장';

-- 18 테이블을 삭제하시오.
DROP TABLE EMP;