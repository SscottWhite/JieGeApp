SELECT * FROM USER a LEFT JOIN sys_menu b ON a.`id` = b.`menu_id` ;

SELECT b.`role_name` FROM sys_user_role a 
	INNER JOIN sys_role b 
	ON a.`role_id` = b.`role_id` 
	WHERE a.`user_id` = 2;


SELECT permission FROM sys_menu  WHERE `menu_id` IN (
   SELECT a.`menu_id` FROM sys_role_menu a 
   INNER JOIN sys_user_role b 
   ON a.`role_id` = b.`role_id`
   WHERE b.`user_id` = 2
)