select name from customer where referee_id != 2 or referee_id is null;


select name from customer where ifnull(referee_id,0)!=2;