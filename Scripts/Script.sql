drop table pdtcode;


create view view_v_output as 
select c.cfCode, c.cfName , s.cfOne, s.cfSell, s.cfMargin, s.cfOne*s.cfSell as salePrise, 
round(s.cfOne*s.cfSell/11, 0) as addTax, s.cfOne*s.cfSell-round(s.cfOne*s.cfSell/11,0) as supplyPrice, 
round(((s.cfOne*s.cfSell-round(s.cfOne*s.cfSell/11,0))*(s.cfMargin/100)),0) as marginPrice 
from pdtcode c , pdtsale s 
where c.cfCode = s.cfCode 
order by salePrise;

drop view view_v_output;