Delimiter $$
use bloodbankmanagementdb;
create procedure get_available_amount(r int)
BEGIN
select  Amount_Available  from available_blood  where BloodGroup = (Select BloodGroup from patients where Id = r);

END $$
Delimiter ;



Delimiter $$
use bloodbankmanagementdb;
create procedure minus_available_amount(am int,i int)
BEGIN
	Update available_blood  set Amount_Available = Amount_Available - am  where Bloodgroup = (Select BloodGroup from patients where Id =i);  
END $$
Delimiter ;




Delimiter $$
use bloodbankmanagementdb;
create procedure donor_transaction(IN id int , IN amt int)
BEGIN
	insert into donated (Id,Amount_Donated) values(id,amt);
END $$
Delimiter ;






Delimiter $$
use bloodbankmanagementdb;
create procedure patient_transaction(IN id int , IN amt int)
BEGIN
	insert into patients_taken_bloood (Id,Amount_Taken) values(id,amt);
END $$
Delimiter ;







