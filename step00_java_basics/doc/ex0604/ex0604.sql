/*
    TRANSACTION
        : INSERT, UPDATE, DELETE 등의 DML문장을 수행할 때 여러 개의 작업을 하나의 단위로 묶어서 한번에 저장(COMMIT), 취소(ROLLBACK) 처리하는 것
        : 특정 영역을 나누어서 ROLLBACK 처리할 수 있다.
*/

-- 현재까지 상황을 COMMIT
COMMIT;

-- 1) INSERT
INSERT INTO SUB_EMP VALUES(8000,'AAA','가가가',5000);

-- 2) UPDATE
UPDATE SUB_EMP SET ENAME = 'BBB' WHERE JOB='MANAGER';

-- 3) DELETE
DELETE FROM SUB_EMP WHERE SAL > 2000;

SELECT * FROM SUB_EMP;

-- 1) 2) 3) 전부 롤백
ROLLBACK;

SAVEPOINT A;

INSERT INTO SUB_EMP VALUES(8000,'AAA','가가가',5000);
INSERT INTO SUB_EMP VALUES(8001,'BBB','나나나',8000);

SAVEPOINT B;

UPDATE SUB_EMP SET ENAME = 'ZZZ' WHERE JOB='MANAGER';
DELETE SUB_EMP WHERE EMPNO IN (7782, 7566);

SAVEPOINT C;

UPDATE SUB_EMP SET JOB='ZZZ';

-- 부분적으로 취소
ROLLBACK TO B;

COMMIT;

---------------------------------------------------------------------------------------------------
/*
    다른계정에 있는 테이블 접근하기
        : 먼저 권한을 부여하여 계정명.테이블이름으로 접근한다.
*/

-- EX) 각자의 계정에서 SCOTT계정에 있는 EMP테이블을 검색해보자.

-- 1) SYSTEM계정으로 접속하여 각자의 계정에게 권한 부여
GRANT ALL ON SCOTT.EMP TO HKALRING;
-- 2) 각자의 계정으로 접속하여
SELECT * FROM SCOTT.EMP;
-- 3) 다 사용한 후에는 권한을 취소한다 (SYSTEM 계정으로 접속)
REVOKE ALL ON SCOTT.EMP FROM HKARLING;

---------------------------------------------------------------------------------------------------
/*

*/

---------------------------------------------------------------------------------------------------



