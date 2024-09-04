select * from muser;

/*문제푸는 순서
1. select 절의 정의
2. select 절의 순서
3. select 절 완성
4. 나머지 완성 못한 부분 어떻게 채울지 결정(함수, 서브쿼리, group by, order by...)*/


/*1) grade가 3인 사람은 모두 몇명인가요?*/
select count(*)         --원하는 값은 인원수..컬럼으로 해결불가..함수사용
from muser
where grade=3;          --grade가 3인 사람은 튜플의 선정조건이라 볼 수 있음 


--2) grade가 1,2,4인 사람들의 salary의 평균을 구하시오.
select avg(salary)         --컬럼값에 함수를 사용해야한다.
from muser
where grade in (1,2,4);      --in 연산자는 or의 의미가 있다.
--where grade=1 or grade=2 or grade=4
--group by                --그룹의 정의: 그룹별 집계일 경우
--order by


--3) salary가 20000 미만인 사람은 총 몇명입니까?
select count(*)
from muser
where salary<20000;
--group by
--order by


--5) 77년생중에
--salary가 가장 적은 사람의 이름과 나이와 salary를 출력하시오.
select  --이름과 나이와 salary
from muser
where   --77년생중에
--group by
--order by
/*77년생 쿼리 테스트 시작*/
select substr(reg_num,1,2) from muser; --중간단계
--본쿼리에 적용
select 
from muser
where substr(reg_num,1,2)=77 ;
/*77년생 쿼리 테스트 끝*/

/*77년생 중에서 가장 작은 salary 뽑아내본다.*/
select min(salary)
from muser
where substr(reg_num,1,2)=77;

--가장 작은 salary를 알면 가장 작은 salary를 조건으로
--가장 작은 salary를 받는 사람의 튜플을 선정할 수 있다.
select * 
from muser
where substr(reg_num,1,2)=77 and salary=10000;

--10000은 상수로 지정하면 안된다. 서브쿼리를 생각
select name 이름, reg_num 나이 ,salary 급여
from muser
where substr(reg_num,1,2)=77 and salary=(
    select min(salary)
    from muser
    where substr(reg_num,1,2)=77);

--나이를 출력한다.. 그런데 위 쿼리는 주민번호를 출력
--컬럼으로 해결가능한가?수식?함수? 서브쿼리> 수식과 함수가 필요
select 1900+substr(reg_num,1,2) from muser;
select * from muser;
--분석: 상수로 1900을 보정하면 2000년 이후 출생자는 오류데이터가 됨
--조건에 따라 1900 또는 2000을 플러스 해줘야 한다.
--검색어: 오라클 조건 > decode
select substr(reg_num,8,1) from muser;
select substr(reg_num,8,1) a,
        decode(substr(reg_num,8,1),'1',1900,'2',1900,2000) b
from muser;
select substr(reg_num,8,1) a,
        decode(substr(reg_num,8,1),'1',1900,'2',1900,2000) b,
        decode(substr(reg_num,8,1),'1',1900,'2',1900,2000)+substr(reg_num,1,2) c
from muser;

--최종쿼리에 대입해봅니다.
select name 이름,
        (extract(year from sysdate))-(decode(substr(reg_num,8,1),'1',1900,'2',1900,2000)
        +substr(reg_num,1,2)) 나이,
        salary 급여
from muser
where substr(reg_num,1,2)=77 and salary=(
    select min(salary)
    from muser
    where substr(reg_num,1,2)=77);
        
--오류낼 수 있는 쿼리
select name, min(salary)
from muser
where substr(reg_num,1,2)=77;  --에러원인은 다중행과 단일행


--7) 남자의 평균 급여를 구하시오.
select avg(salary) --평균급여
from muser
where substr(reg_num,8,1) in ('1','3')          --남자? 컬럼으로 안된다. 수식이나 함수나 서브쿼리..함수와 수식 필요
--group by
--order by


--8) 전체 평균급여보다 높은 급여를 받는 사람의 이름과 급여를 출력하시오
select name, salary
from muser
where --평균급여보다 높은 급여 받는 사람의 튜플 선택
        --컬럼자체로 해결?수식?함수?서브쿼리?
        --평균급여의 결과값으로 조건을 완성 ->서브쿼리
select name,salary
from muser
where salary>
    (select avg(salary)
    from muser);


--9) 전체 평균급여보다 높은 급여를 받는 사람의 이름과 급여, 평균급여를 출력
select name,salary,
    (select avg(salary) --스칼라 서브쿼리, 대안책..조인
    from muser) 평균급여  --수식?함수?서브쿼리
from muser
where salary>
    (select avg(salary)
    from muser);
    --성능은 별로임..왜냐하면 본쿼리 select에서 
    --튜플을 하나씩 완성해갈 때마다 서브쿼리를 실행한다.
    --동일한 서브쿼리를 계속 실행하기 때문이다.


--12) 그룹별 평균급여가 전체 평균보다 높은 그룹을 출력하시오.

--그룹별 평균을 구한다...이 그룹중에 전체 평균보다 높은 그룹 선택
select grade, avg(salary)
from muser
--where
group by grade having avg(salary)>(
                                    select avg(salary)
                                    from muser);                               
--order by
  

--14) 직원들의 성별을 출력하시오. (출력 형태 이름, 성별(성별은 남또는 여로 출력한다)
select name,
        decode(substr(reg_num,8,1),'1','남','3','남','여') 성별
from muser;
--where
--group by
--order by

/*오라클에 조건에 따라 처리하는 문법은 case when then else end*/
--case when then else end의 구조를 분석
--case
--      when 조건1 then 조건1이 참일 경우 실행
--      when 조건2 then 조건2가 참일 경우 실행
--      else 조건1과 조건2 어느것도 참이지 않을 경우 실행
--end
select name 이름,
        case
            when substr(reg_num,8,1) in ('1','3') then '남'
            else '여'
        end 성별
from muser;

select distinct grade, salary from muser;
--distinct는 중복된 컬럼을 제거하고 select절에서 한번만 사용이 가능
--중복제거 범위는 select 에서 지정한 전체 행의 중복이다.
--#3번 문제에서 연령별(time 컬럼) 급여의 합.over 함수 이용
select  distinct 
        time 연령, 
        sum(salary) over(partition by time) 총합
from muser;

--#2번문제
    
select 
    ( select trunc(sum(months_between(sysdate,substr(reg_num,1,6))))
    from muser where time in (30,31) ) as 삼공삼일,
    (select trunc(sum(months_between(sysdate,substr(reg_num,1,6))))
    from muser where time>=32) as 삼이
from dual;





