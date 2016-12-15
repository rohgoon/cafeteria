drop table pdtcode;
drop table pdtsale;


create view view_v_output as 
select c.cfCode, c.cfName , s.cfOne, s.cfSell, s.cfMargin, s.cfOne*s.cfSell as salePrise, 
round(s.cfOne*s.cfSell/11, 0) as addTax, s.cfOne*s.cfSell-round(s.cfOne*s.cfSell/11,0) as supplyPrice, 
round(((s.cfOne*s.cfSell-round(s.cfOne*s.cfSell/11,0))*(s.cfMargin/100)),0) as marginPrice 
from pdtcode c , pdtsale s 
where c.cfCode = s.cfCode 
order by salePrise;

drop view view_v_output;

select (select count(*)+1 from cafeteria.view_v_output as e2 where e1.salePrice < e2.salePrice) as rnk, cfCode, cfName, cfOne, cfSell, cfMargin, salePrice, addTax, supplyPrice, marginPrice from cafeteria.view_v_output e1 order by salePrice desc;