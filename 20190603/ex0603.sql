---------------------------------------------------------------------------------------------------
------------ 테이블 만들기 ------------
-- 과목 SUBJECT
CREATE TABLE SUBJECT(
    수강코드 VARCHAR2(5) PRIMARY KEY,
    과목 VARCHAR2(20) NOT NULL
);

INSERT INTO SUBJECT VALUES('j1001','sql');
INSERT INTO SUBJECT VALUES('j1002','Win2000');
INSERT INTO SUBJECT VALUES('j1003','ASP');
INSERT INTO SUBJECT VALUES('j1004','Php');
INSERT INTO SUBJECT VALUES('j1005','java');
INSERT INTO SUBJECT VALUES('j1006','javascript');

CREATE TABLE ROOM(
    강의실번호 NUMBER PRIMARY KEY,
    수용인원 NUMBER NOT NULL
);
INSERT INTO ROOM VALUES(901, 34);
INSERT INTO ROOM VALUES(902, 35);
INSERT INTO ROOM VALUES(903, 25);
INSERT INTO ROOM VALUES(904, 32);
INSERT INTO ROOM VALUES(905, 30);
INSERT INTO ROOM VALUES(906, 35);

CREATE TABLE STUDENT(
    수강생번호 NUMBER PRIMARY KEY,
    수_이름 VARCHAR2(12) NOT NULL,
    수_주민등록번호 VARCHAR2(14) NOT NULL,
    수_연락처 VARCHAR2(14) NOT NULL,
    수_주소 VARCHAR2(50),
    수_이메일 VARCHAR2(20)
);

INSERT INTO STUDENT VALUES (1,'김현진','771212-2346111','017-888-8888','부산','aaa@hanmail.net');
INSERT INTO STUDENT VALUES (2,'김석주','720112-1234812','016-999-9999','경기','bbb@hanmail.net');
INSERT INTO STUDENT VALUES (3,'고훈기','730102-1555555','017-555-5555','서울','ccc@hanmail.net');
INSERT INTO STUDENT VALUES (4,'유민경','801111-2222222','017-222-2222','전남','ddd@hanmail.net');
INSERT INTO STUDENT VALUES (5,'김영수','811231-1777777','017-777-7777','충주','eee@hanmail.net');
INSERT INTO STUDENT VALUES (6,'박상원','790915-1333333','017-333-3333','강원','fff@hanmail.net');

CREATE TABLE TEACHER(
    강사번호 NUMBER PRIMARY KEY,
    강사이름 VARCHAR2(12) NOT NULL,
    주민등록번호 VARCHAR2(14) NOT NULL,
    연락처 VARCHAR2(14) NOT NULL,
    주소 VARCHAR2(50),
    이메일 VARCHAR2(20),
    수강코드 VARCHAR2(5) REFERENCES SUBJECT(수강코드)
);

INSERT INTO TEACHER VALUES(1,'홍길동','700918-1622011','031-295-1234','성남시 중원구 신흥동','kkk@jok.or.kr','j1001');
INSERT INTO TEACHER VALUES(2,'유관순','710419-2018916','02-345-2345','서울 강남구 개포동','kkk@jok.or.kr','j1002');
INSERT INTO TEACHER VALUES(3,'이승복','730112-1344911','031-1234-6789','서울시 강남구 논현동','sss@jok.or.kr','j1003');
INSERT INTO TEACHER VALUES(4,'모택동','730301-1167623','031-567-5678','서울시 서초구 서초동','mmm@jok.or.kr','j1004');
INSERT INTO TEACHER VALUES(5,'주롱지','730322-2037921','031-789-3456','서울시 강서구 가양동','xxx@jok.or.kr','j1005');
INSERT INTO TEACHER VALUES(6,'이순신','731122-1646213','031-234-8901','서울시 강북구 미아동','ppp@jok.or.kr','j1006');

CREATE TABLE SUGANG (
    수강생번호 NUMBER PRIMARY KEY REFERENCES STUDENT(수강생번호),
    수강코드 VARCHAR2(5) REFERENCES SUBJECT(수강코드)
);

INSERT INTO SUGANG VALUES(1, 'j1001');
INSERT INTO SUGANG VALUES(2, 'j1002');
INSERT INTO SUGANG VALUES(3, 'j1003');
INSERT INTO SUGANG VALUES(4, 'j1004');
INSERT INTO SUGANG VALUES(5, 'j1005');
INSERT INTO SUGANG VALUES(6, 'j1006');

CREATE TABLE SUGANGTB (
    수강코드 VARCHAR2(25) PRIMARY KEY REFERENCES SUBJECT(수강코드),
    강의실번호 NUMBER REFERENCES ROOM(강의실번호),
    시간 NUMBER NOT NULL,
    강사번호 NUMBER REFERENCES TEACHER(강사번호)
);

INSERT INTO SUGANGTB VALUES('j1001', 901, 2, 1);
INSERT INTO SUGANGTB VALUES('j1002', 902, 2, 2);
INSERT INTO SUGANGTB VALUES('j1003', 903, 2, 3);
INSERT INTO SUGANGTB VALUES('j1004', 904, 2, 4);
INSERT INTO SUGANGTB VALUES('j1005', 905, 2, 5);
INSERT INTO SUGANGTB VALUES('j1006', 906, 2, 6);

---------------------------------------------------------------------------------------------------
/*
    Subquery
        : 메인쿼리 안에 또다른 쿼리가 존재하는 것
        : 반드시 괄호로 묶고 괄호 안의 서브쿼리가 실행된 후 그 결과를 메인쿼리에 이용한다.
        : 조건에 많이 사용된다.
        : 서브쿼리의 결과의 행이 한 개일 때는 비교연산자를 이용하고 2개 이상일 때는 IN, ANY, ALL을 사용한다.
        : 주로 SELECT 절에서 많이 사용하지만 INSERT, UPDATE, DELETE 에도 사용이 가능하다.
*/

-- EX) EMP 테이블에서 평균급여보다 많이 받는 사원의 정보 검색.
    -- 1) 평균급여를 구한다.
    SELECT AVG(SAL) FROM EMP; -- 2077

    -- 2) 1)의 결과를 조건으로 사용한다.
    SELECT * FROM EMP WHERE SAL > 2077

    -- ** 위의 두 문장을 서브쿼리를 이용해 한 문장으로 실행한다.
    SELECT * FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP);

-- EX) JOB에 'A' 문자열이 들어간 사원의 부서와 같은 곳에 근무하는 사원의 부서이름을 검색한다.
SELECT DNAME FROM EMP JOIN DEPT USING(DEPTNO) WHERE DEPTNO IN (SELECT DISTINCT DEPTNO FROM EMP WHERE JOB LIKE '%A%');

-- EX) 부서번호가 30인 사원원들의 급여중에서 가장 많은 급여보다 더 많이 받는 사원의 정보를 구한다.
SELECT * FROM EMP WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);
SELECT * FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);

-- EX) 부서번호가 30인 사원원들의 급여중에서 가장 많은 급여보다 더 많이 받는 사원의 정보를 구한다.
SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);
SELECT * FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30);

/*
    SUBQUERY를 이용한 INSERT
*/

-- EX) EMP 테이블에서 급여가 3000 이상인 사원 정보를 가져와서 INSERT 해본다.
INSERT INTO SUB_EMP(SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 3000);
SELECT * FROM SUB_EMP;

-- EX) 특정 컬럼만 선택적으로 추가하기
INSERT INTO SUB_EMP(EMPNO, JOB)(SELECT EMPNO, JOB FROM EMP WHERE ENAME LIKE '%R');

/*
    SUBQUERY를 이용한 UPDATE
*/

-- EX) SUB_EMP 평균 급여를 가져와서 값으로 사용한다.
UPDATE SUB_EMP SET SAL = (SELECT AVG(SAL) FROM SUB_EMP) WHERE SAL < (SELECT AVG(SAL) FROM SUB_EMP);

UPDATE SUB_EMP SET (JOB, SAL) = (SELECT JOB, SAL FROM EMP WHERE EMPNO=7902) WHERE EMPNO=7844;

/*
    SUBQUERY를 이용한 DELETE
*/

-- EX)
DELETE FROM SUB_EMP WHERE SAL > (SELECT AVG(SAL) FROM SUB_EMP);

/*
    INLINE VIEW : FROM 절 뒤에 SUBQUERY가 오는 것.
*/

-- * ROWNUM : 자동으로 레코드가 만들어질때 행 번호를 부여.
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL FROM EMP;

-- 급여를 기준으로 정렬하여 ROWNUM을 사용하고 싶다.
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL FROM EMP ORDER BY SAL; -- 번호가 제대로 순서대로 되지않는다
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL FROM (SELECT * FROM EMP ORDER BY SAL);

-- 위의 쿼리에 조건을 넣어보자
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL FROM (SELECT * FROM EMP ORDER BY SAL) WHERE ROWNUM <= 3; -- 실행순서때문에 안된다.
SELECT * FROM (SELECT ROWNUM, EMPNO, ENAME, JOB, SAL FROM (SELECT * FROM EMP ORDER BY SAL)) WHERE ROWNUM <= 3;

---------------------------------------------------------------------------------------------------
------ 문제

-- SUBEMP 테이블 생성 / 데이터삽입
CREATE TABLE SUBEMP(
    EMP_ID INT, -- 사원번호
    EMP_NAME VARCHAR2(20) NOT NULL, -- 사원이름
    JOB VARCHAR2(20) NOT NULL, -- 직업
    DEPT_ID INT, -- 부서번호
    SAL INT NOT NULL, -- 급여
    BONUS INT, -- 보너스
    MGR_ID INT, -- 관리자번호
    HIREDATE DATE NOT NULL, -- 입사일
    CONSTRAINT EMP_ID_PK PRIMARY KEY(EMP_ID) -- 제약조건
);

INSERT INTO SUBEMP VALUES (6200,'박철수','대표',200,5000,NULL,NULL, '1997-12-17');
INSERT INTO SUBEMP VALUES (6311,'김대정','부장',100,3500,Null,6200, '1998-12-17');
INSERT INTO SUBEMP VALUES (7489,'민동규','세일즈',400,1850,200,6321, '1999-02-27');
INSERT INTO SUBEMP VALUES (7522,'정종철','세일즈',400,1850,300,6321,'1998-02-28');
INSERT INTO SUBEMP VALUES (6321,'이종길','부장',400,3800,500,6200,'1999-04-20');
INSERT INTO SUBEMP VALUES (6351,'진대준','부장',300,2850,NULL,6200,'2000-05-31');
INSERT INTO SUBEMP VALUES (7910,'이영희','경리',300,1000,NULL,6351,'2001-05-01');
INSERT INTO SUBEMP VALUES (6361,'김철수','부장',200,3200,NULL,6200,'2000-06-09');
INSERT INTO SUBEMP VALUES (7878,'백기수','연구직',200,3000,NULL,6361,'2001-06-05');
INSERT INTO SUBEMP VALUES (7854,'진영진','세일즈',400,1500,0,6321,'2001-09-08');
INSERT INTO SUBEMP VALUES (7872,'이문정','사무직',100,1500,NULL,6311,'2001-02-12');
INSERT INTO SUBEMP VALUES (7920,'마리아','사무직',300,1050,NULL,6351,'2001-03-18');
INSERT INTO SUBEMP VALUES (7901,'정동길','연구직',NULL,3000,NULL,NULL,'2001-12-03');
INSERT INTO SUBEMP VALUES (7933,'김철수','사무직',200,1050,NULL,6361,'2002-01-02');

-- SUBDEPT 테이블 생성 / 레코드 추가
SELECT * FROM SUBDEPT;
CREATE TABLE SUBDEPT(SUBDEPT_ID int, DNAME VARCHAR(20) );
INSERT INTO SUBDEPT VALUES(100,'관리부');
INSERT INTO SUBDEPT VALUES(200,'경리부');
INSERT INTO SUBDEPT VALUES(300,'생산부');
INSERT INTO SUBDEPT VALUES(400,'영업부');

-- EX1) 이종길 사원의 부서명(dname)을 검색하시오.
SELECT DNAME FROM SUBDEPT WHERE DEPT_ID = (SELECT DEPT_ID FROM SUBEMP WHERE EMP_NAME = '이종길');

-- EX2) DEPT_ID 가 100인 사원급여의 최대값보다 많이 받는 사원을 검색하시오.
SELECT * FROM SUBEMP WHERE SAL > (SELECT MAX(SAL) FROM SUBEMP WHERE DEPT_ID = 100);

-- EX3)급여를 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 정보
SELECT * FROM SUBEMP WHERE DEPT_ID = ANY (SELECT DEPT_ID FROM SUBEMP WHERE SAL >= 3000);

-- EX4) 부서번호가 300인 사원들중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사람의 정보를 검색.
SELECT * FROM SUBEMP WHERE SAL > (SELECT MAX(SAL) FROM SUBEMP WHERE DEPT_ID = 300);

-- EX5) 부서번호가 300인 사원들중에서 급여를 가장 적게 받는 사원보다 더 많은 급여를 받는 사람의 정보를 검색
SELECT * FROM SUBEMP WHERE SAL > (SELECT MIN(SAL) FROM SUBEMP WHERE DEPT_ID = 300);   

-- EX6) 정동길의 급여와 동일 하거나 더 많이 받는 사원의 정보검색
SELECT * FROM SUBEMP WHERE SAL >= (SELECT SAL FROM SUBEMP WHERE EMP_NAME = '정동길'); 

-- EX7)직급이 사무직인 사원의 부서번호와 부서명 출력
SELECT DEPT_ID, DNAME FROM SUBDEPT WHERE DEPT_ID IN (SELECT DISTINCT DEPT_ID FROM SUBEMP WHERE JOB = '사무직');

-- EX8) 부서가 경리부인 모든 사원의 정보출력
SELECT * FROM SUBEMP WHERE DEPT_ID = (SELECT DEPT_ID FROM SUBDEPT WHERE DNAME = '경리부');

-- EX9)대표이사에게 보고를 하는 모든 사원의 정보출력
SELECT * FROM SUBEMP WHERE MGR_ID = (SELECT EMP_ID FROM SUBEMP WHERE JOB = '대표');

-- EX10) 이름에 '정'이 들어가면서 평균급여보다 높은 급여를 받는 사원과 동일한 부서에서 근무하는 사원의 정보 검색. (단, 부서번호 null은 제외함)
SELECT * FROM SUBEMP WHERE DEPT_ID = (SELECT DEPT_ID FROM SUBEMP WHERE EMP_NAME LIKE '%정%' AND SAL > (SELECT AVG(SAL) FROM SUBEMP) AND DEPT_ID IS NOT NULL);

-- EX11) 각 부서의 어떤 평균 급여보다 급여를 많이 받는 사원의 정보를 검색
SELECT * FROM SUBEMP WHERE SAL > ALL (SELECT AVG(SAL) FROM SUBEMP GROUP BY DEPT_ID);

-- EX12)  모든 사무직 사원보다 급여가 적으면서 사무직이 아닌 모든 사원의 정보검색
SELECT * FROM SUBEMP WHERE JOB != '사무직' AND SAL < (SELECT MIN(SAL) FROM SUBEMP WHERE JOB = '사무직');

---------------------------------------------------------------------------------------------------
/*
    View - 가상테이블
        : 보안 or 복잡한 쿼리를 단순화 시키기 위해서 사용한다.
        : 뷰를 생성할 때 어떻게 생성하느냐에 따라 DML(INSERT, UPDATE, DELETE) 가능여부가 달라진다.
        : VIEW 생성하는 방법
            CREATE OR REPLACE VIEW 뷰이름 AS 뷰내용(원본))
            [WITH READ ONLY] -- 읽기 전용
            [WITH CHECK OPTION] -- 조건에 만족하지 않는 레코드는 DML되지 않는다.
        : VIEW 삭제
            DROP VIEW 뷰이름;

            * VIEW 를 생성하려면 기본적으로 뷰를 CREATE 할 수 있는 권한이 필요하다.
              EX) GRANT CREATE VIEW [ID]..
*/

-----------
-- 테이블 생성
CREATE TABLE VIEW_EMP AS SELECT * FROM EMP;

-- VIEW 생성
CREATE VIEW V_EMP AS SELECT * FROM VIEW_EMP;

-- VIEW에서 INSERT를 해본다. 
INSERT INTO V_EMP(EMPNO, ENAME, JOB, SAL) VALUES(8888,'뷰연습','잘되나',3000);

-- 원본에서 INSERT를 해본다
INSERT INTO V_EMP(EMPNO, ENAME, JOB, SAL) VALUES(8889,'뷰연습2','잘되2',3000);

-- VIEW 에서 삭제
DELETE FROM V_EMP WHERE JOB = 'MANAGER';

-----------
-- 보안적인 측면에서 VIEW 사용하기 : 권한에 따라 VIEW의 테이블만 개방한다.
CREATE OR REPLACE VIEW V_EMP AS SELECT EMPNO, ENAME, JOB, SAL, COMM, DEPTNO FROM VIEW_EMP WHERE DEPTNO = 30;

-- VIEW에 INSERT를 해본다.
INSERT INTO V_EMP(EMPNO, ENAME, JOB, SAL, COMM, DEPTNO) VALUES (9000,'AAA','가가가',300,100,30); -- 성공.
INSERT INTO V_EMP(EMPNO, ENAME, JOB, SAL, COMM, DEPTNO) VALUES (9001,'BBB','나나나',5000,1000,10); -- 성공하나 V_EMP테이블에서 겁색하면 검색이 되지 않는다. 그래서 VIEW를 생성할때 조건을 주었다면 WITH CHECK OPTION과 함께 사용하는 것을 권장한다.

-- VIEW를 변경해보자
CREATE OR REPLACE VIEW V_EMP AS SELECT EMPNO, ENAME, JOB, SAL, COMM, DEPTNO FROM VIEW_EMP WHERE DEPTNO = 30 WITH CHECK OPTION;

-- 다시 VIEW에 INSERT를 해본다.
INSERT INTO V_EMP(EMPNO, ENAME, JOB, SAL, COMM, DEPTNO) VALUES (9002,'CCC','다다다',300,100,30); -- 성공.
INSERT INTO V_EMP(EMPNO, ENAME, JOB, SAL, COMM, DEPTNO) VALUES (9003,'DDD','라라라',5000,1000,10); -- view WITH CHECK OPTION where-clause violation

----------
-- VIEW를 생성할때 읽기전용(SELECT 전용)
CREATE OR REPLACE VIEW V_EMP AS SELECT EMPNO, ENAME, JOB, SAL, COMM, DEPTNO FROM VIEW_EMP WHERE DEPTNO = 30 WITH READ ONLY;

-- VIEW에 INSERT를 해본다.
INSERT INTO V_EMP(EMPNO, ENAME, JOB, SAL, COMM, DEPTNO) VALUES (9003,'DDD','라라라',5000,1000,10); -- cannot perform a DML operation on a read-only view

----------
-- 복잡한 쿼리(join, subquery)를 단순화 시키기 위해서 뷰를 사용
CREATE OR REPLACE VIEW V_EMP AS
SELECT EMPNO, E.EMPNO, ENAME, JOB, SAL, DNAME, LOC, GRADE
FROM EMP E JOIN DEPT D ON E.DEPTNO = D.DEPTNO
    JOIN SALGRADE S ON SAL BETWEEN S.LOSAL AND S.HISAL
WHERE EMPNO=7369;

---------------------------------------------------------------------------------------------------
/*
    SEQUENCE
        : 자동증가 컬럼에 값을 자동 설정!
        : 생성방법
            CREATE SEQUENCE 시퀀스명
                [START WITH 시작값]
                [INCREMENT BY 증가값]
                [MAXVALUE 최대값]
                [MINVALUE 최소값]
                [CYCLE | NO CYCLE]
                [CACHE | NO CACHE]
        : 사용법
            시퀀스이름.NEXTAL
            시퀀스이름.CURRVAL
        : 시퀀스 수정
            ALTER SEQUENCE 시퀀스명
        : 시퀀스 삭제
            DROP SEQUENCE 시퀀스명
*/

-- 시퀀스 생성
CREATE SEQUENCE SEQ_NO;
SELECT SEQ_NO.NEXTVAL, SEQ_NO.CURRVAL FROM DUAL;

-- 시퀀스 삭제
DROP SEQUENCE SEQ_NO;

-- 시퀀스 생성
CREATE SEQUENCE SEQ_NO INCREMENT BY 5 START WITH 10 MINVALUE 5 MAXVALUE 100 CYCLE NOCACHE;

-- 실제 사용 용도
CREATE TABLE BOARD(
    BOARD_NO NUMBER(3) PRIMARY KEY, -- 글번호
    SUBJECT VARCHAR2(30) NOT NULL,
    WRITER VARCHAR2(20), 
    CONTENT VARCHAR2(100),
    REGDATE DATE DEFAULT SYSDATE
);

-- 글번호에 사용하게될 SEQUENCE 필요
CREATE SEQUENCE BOARD_NO_SEQ NOCACHE;

-- 레코드 추가하기
INSERT INTO BOARD VALUES(BOARD_NO_SEQ.NEXTVAL, 'SQL', 'AAA', '가가가가가가가가', SYSDATE);

---------------------------------------------------------------------------------------------------
------ 문제 ------
-- 1. 성별이 여자인 학생의 정보 검색
SELECT * FROM STUDENT WHERE 수_주민등록번호 LIKE '%-2%';

-- 2. 생년월일이 1973년인 수강생 정보를 검색 (SUBSTR이용)
SELECT * FROM STUDENT WHERE SUBSTR(수_주민등록번호, 1, 2) = '73';

-- 3. 성이 '홍'이 아닌 강사의 정보검색
SELECT * FROM TEACHER WHERE 강사이름 NOT LIKE '홍%';

-- 4. 강남구에 거주하는 강사의 정보검색
SELECT * FROM TEACHER WHERE 주소 LIKE '%강남구%';

-- 5. Java를 강의하는 강사 정보검색
SELECT * FROM TEACHER WHERE 수강코드 = (SELECT 수강코드 FROM SUBJECT WHERE UPPER(과목) = 'JAVA');

-- 6. 주소가 NULL이 아닌 강사의 정보 검색
SELECT * FROM TEACHER WHERE 주소 IS NOT NULL;

-- 7. SQL 수업을 수강하고 있는 학생의 정보를 검색하는 뷰 작성
CREATE VIEW SQL_STUDENT AS SELECT * FROM STUDENT WHERE 수강생번호 = (SELECT 수강생번호 FROM SUBJECT JOIN SUGANG USING(수강코드) WHERE UPPER(과목)= 'SQL');
SELECT * FROM SQL_STUDENT;

-- 8. 강사가 담당하는 과목과 그 과목이 어느 강의실에서 진행되며 총 수용 인원이 몇명인지 검색 (JOIN을 이용하여 뷰작성)
CREATE VIEW TEACHER_INFO AS SELECT 강사번호, 강사이름, 수강코드, 과목, 강의실번호, 수용인원 FROM TEACHER T JOIN SUBJECT SB ON t.수강코드 = sb.수강코드 JOIN SUGANGTB ST USING(강사번호) JOIN ROOM R USING(강의실번호);
SELECT * FROM TEACHER_INFO;

-- 9. 아래의 그림을 보고 만드세요 (학생의 이름, 주민번호, 성별을 출력)
SELECT 수_이름, 수_주민등록번호, (CASE WHEN 수_주민등록번호 LIKE '%-1%' THEN '남자' ELSE '여자' END) 성별 FROM STUDENT;

-- 10. 아래의 그림을 보고 만드세요. 강사 이름을 기준으로 올림차순으로 정렬하여 정렬된 순서대로 ROWNUM이 출력되게 하세요.
SELECT ROWNUM, 강사이름, 연락처, 주소 FROM (SELECT 강사이름, 연락처, 주소 FROM TEACHER ORDER BY 강사이름);