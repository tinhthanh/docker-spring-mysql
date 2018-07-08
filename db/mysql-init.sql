USE `internship` ;

-- -----------------------------------------------------
-- Table `internship`.`drs_config_param`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_config_param` (
  `config_key` VARCHAR(100) NOT NULL,
  `config_value` VARCHAR(500) NOT NULL,
  `config_description` VARCHAR(255) NULL DEFAULT NULL,
  `last_edit_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE INDEX `config_key_UNIQUE` (`config_key` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `full_name` VARCHAR(50) NULL DEFAULT NULL,
  `status` INT(11) NOT NULL COMMENT '1:account is enabled\n2: account is locked\n3:account has expired\n4:account is disable ',
  `last_password_change` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_custom_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_custom_task` (
  `custom_task_id` INT(11) NOT NULL AUTO_INCREMENT,
  `task_name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `target_date` DATE NULL DEFAULT NULL,
  `task_status` INT(11) NULL DEFAULT NULL,
  `remark` TEXT NULL DEFAULT NULL,
  `custom_task_status` TINYINT(1) NULL DEFAULT '1',
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`custom_task_id`),
  INDEX `fk_custom_task_drs_user_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_custom_task_drs_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `internship`.`drs_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 38
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_group_contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_group_contact` (
  `group_contact_id` INT(11) NOT NULL AUTO_INCREMENT,
  `group_contact_name` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  `group_contact_status` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`group_contact_id`),
  INDEX `fk_drs_card_visit_drs_user_idx` (`user_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 70
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_group_contact_content`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_group_contact_content` (
  `group_contact_content_id` INT(11) NOT NULL AUTO_INCREMENT,
  `recipient_email` VARCHAR(255) NOT NULL,
  `recipient_action` TINYINT(3) NOT NULL COMMENT '1:to\n2:cc',
  `group_contact_id` INT(11) NOT NULL,
  `group_contact_content_status` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '1: exist\n0: delete',
  PRIMARY KEY (`group_contact_content_id`),
  INDEX `fk_drs_card_visit_content_drs_card_visit_card_visit_id_idx` (`group_contact_id` ASC),
  CONSTRAINT `fk_drs_group_contact_content_drs_group_contact_group_contact_id`
    FOREIGN KEY (`group_contact_id`)
    REFERENCES `internship`.`drs_group_contact` (`group_contact_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 78
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_issue_tracker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_issue_tracker` (
  `issue_tracker_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(50) NOT NULL,
  `issue_id` INT(11) NOT NULL,
  `update_time` DATETIME NOT NULL,
  `issue_tracker_status` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`issue_tracker_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_role` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_permission` (
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `fk_role_permission_idx` (`role_id` ASC),
  CONSTRAINT `fk_role_permission`
    FOREIGN KEY (`role_id`)
    REFERENCES `internship`.`drs_role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_permission`
    FOREIGN KEY (`user_id`)
    REFERENCES `internship`.`drs_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_report` (
  `report_id` INT(11) NOT NULL AUTO_INCREMENT,
  `report_subject` VARCHAR(255) NULL DEFAULT NULL,
  `report_type` TINYINT(4) NOT NULL COMMENT '1:save\n2:send\n',
  `data_etc` VARCHAR(255) NULL DEFAULT NULL,
  `action_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` INT(11) NULL DEFAULT NULL,
  `report_status` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`report_id`),
  INDEX `fk_reporter_report_reporter_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_reporter_report_reporter_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `internship`.`drs_user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 42172
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_report_privileges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_report_privileges` (
  `report_privileges_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `user_report_name` VARCHAR(45) NULL DEFAULT NULL,
  `user_report_id` VARCHAR(45) NULL DEFAULT NULL,
  `start_date` TIMESTAMP NULL DEFAULT NULL,
  `end_date` TIMESTAMP NULL DEFAULT NULL,
  `privileges_status` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`report_privileges_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 142
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_report_recipient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_report_recipient` (
  `report_recipient_id` INT(11) NOT NULL AUTO_INCREMENT,
  `report_recipient_email` VARCHAR(255) NOT NULL,
  `report_recipient_action` TINYINT(3) NOT NULL COMMENT '1:to\n2:cc',
  `report_id` INT(11) NULL DEFAULT NULL,
  `report_recipient_status` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`report_recipient_id`),
  INDEX `fk_drs_report_recipient_drs_report_report_id_idx` (`report_id` ASC),
  CONSTRAINT `fk_drs_report_recipient_drs_report_report_id`
    FOREIGN KEY (`report_id`)
    REFERENCES `internship`.`drs_report` (`report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 349
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `internship`.`drs_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internship`.`drs_task` (
  `task_id` INT(11) NOT NULL AUTO_INCREMENT,
  `task_name` TEXT NULL DEFAULT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `target_date` DATE NULL DEFAULT NULL,
  `task_status` INT(11) NULL DEFAULT NULL,
  `remark` TEXT NULL DEFAULT NULL,
  `report_id` INT(11) NULL DEFAULT NULL,
  `task_date_defined` TINYINT(2) NULL DEFAULT '1' COMMENT '1:to day\n2: tomorrow',
  `task_delete_status` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`task_id`),
  INDEX `fk_reporter_task_reporter_report_report_id_idx` (`report_id` ASC),
  CONSTRAINT `fk_reporter_task_reporter_report_report_id`
    FOREIGN KEY (`report_id`)
    REFERENCES `internship`.`drs_report` (`report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 522
DEFAULT CHARACTER SET = utf8;

USE `internship` ;

-- -----------------------------------------------------
-- procedure up_DRSCheckCustomTaskDeleted
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSCheckCustomTaskDeleted`(IN p_id INT(11))
BEGIN
SELECT count(custom_task_id)
FROM drs_custom_task
WHERE custom_task_id = p_id  && custom_task_status = 0;

 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSCheckOwnerCustomTask
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSCheckOwnerCustomTask`( 
				IN p_user_id INT(11), 
				IN p_custom_task_id int(11))
BEGIN
	SELECT EXISTS (SELECT 1 FROM drs_custom_task
	WHERE (user_id, custom_task_id) =(p_user_id, p_custom_task_id)); 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSCreateCustomTask
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSCreateCustomTask`(
					IN p_task_name VARCHAR(255), 
					IN p_description VARCHAR(255), 
					IN p_target_date DATE, 
					IN p_task_status INT, 
					IN p_remark TEXT,
                    IN p_user_id INT(11))
BEGIN
		INSERT INTO drs_custom_task(task_name, description, target_date, task_status, remark, custom_task_status, user_id)
			VALUES(p_task_name, p_description, p_target_date, p_task_status, p_remark, 1, p_user_id);
		SELECT LAST_INSERT_ID();
	END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSCreateIssueTracker
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSCreateIssueTracker`(IN p_user_name VARCHAR(50),IN p_issue_id INT,IN p_update_time DATETIME,OUT p_issue_track_id INT)
BEGIN
	SET @issue_tracker_id =-1;
    
   IF NOT (SELECT EXISTS (SELECT 1 FROM drs_issue_tracker i 
							WHERE i.user_name=p_user_name 
                            AND   i.issue_id=p_issue_id
                            AND   DATE(i.update_time)=DATE(p_update_time)
                            )) THEN
                            
               INSERT INTO  drs_issue_tracker(user_name,issue_id,update_time) VALUES(p_user_name,p_issue_id,p_update_time);    
               
               SELECT LAST_INSERT_ID() INTO @issue_tracker_id FROM DUAL;
                         
                         END IF;
	SELECT @issue_tracker_id INTO p_issue_track_id;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSDeleteCustomTask
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSDeleteCustomTask`(IN p_id INT(11))
BEGIN
update drs_custom_task set custom_task_status = 0 WHERE custom_task_id = p_id; 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSDeleteReport
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSDeleteReport`(IN reportId INT)
BEGIN
UPDATE drs_report
SET report_status = 0
WHERE report_id = reportId; 
SELECT ROW_COUNT();

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetAllConfigParam
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetAllConfigParam`()
BEGIN
SELECT c.config_key,
       c.config_value
FROM drs_config_param c;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetAllGcByUserIdAndStatus
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetAllGcByUserIdAndStatus`(IN p_page_number INT, IN p_page_size INT, IN p_user_id INT, IN p_group_contact_status TINYINT(1),OUT p_total_record INT)
BEGIN
DECLARE v_start INT;
DECLARE v_total_records INT;
SET v_start =  (p_page_number-1)*p_page_size;

SET v_total_records = (
SELECT COUNT(1)
FROM drs_group_contact gc 
WHERE gc.user_id=p_user_id 
AND gc.group_contact_status=p_group_contact_status);

SELECT v_total_records INTO p_total_record;

SELECT gc.group_contact_id, gc.group_contact_name
FROM drs_group_contact gc 
WHERE gc.user_id=p_user_id 
AND gc.group_contact_status=p_group_contact_status 
LIMIT p_page_size 
OFFSET v_start;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetAllIssueTrackerByUserNameAndDate
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetAllIssueTrackerByUserNameAndDate`(IN p_user_name VARCHAR(50),IN p_update_time DATE)
BEGIN
SELECT issue_tracker_id AS issueTrackerId,
		user_name       AS userName,
		issue_id        AS 	issueId,
        update_time     AS   updateTime
        
        FROM drs_issue_tracker i 
		WHERE i.user_name =p_user_name 
		AND DATE(i.update_time)=p_update_time 
        AND issue_tracker_status =1;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetCustomTask
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetCustomTask`(IN p_user_id INT(11), IN p_custom_task_status TINYINT(1))
BEGIN
SELECT custom_task_id,
       task_name,
       description,
       target_date,
       task_status,
       remark
FROM drs_custom_task
WHERE user_id = p_user_id && custom_task_status = p_custom_task_status ; END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetCustomTaskByID
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetCustomTaskByID`(IN p_id INT(11))
BEGIN
SELECT custom_task_id,
       task_name,
       description,
       target_date,
       task_status,
       remark
FROM drs_custom_task
WHERE custom_task_id = p_id  && custom_task_status = 1 ; 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetCustomTaskByUserId
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetCustomTaskByUserId`(IN p_user_id INT)
BEGIN
SELECT custom_task_id,
       task_name,
       description,
       target_date,
       task_status,
       remark
FROM drs_custom_task
WHERE user_id = p_user_id
AND custom_task_status = 1;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetGcByIdAndStatus
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetGcByIdAndStatus`(IN p_group_contact_id INT,IN p_group_contact_status TINYINT(1))
BEGIN
SELECT gc.group_contact_id,
       gc.group_contact_name
FROM drs_group_contact gc
WHERE gc.group_contact_id=p_group_contact_id
  AND gc.group_contact_status=p_group_contact_status; 
  END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetGccByGcIdAndStatus
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetGccByGcIdAndStatus`(IN p_group_contact_id INT,IN p_group_contact_content_status TINYINT(1))
BEGIN
SELECT gcc.group_contact_content_id,
       gcc.recipient_email,
       gcc.recipient_action,
       gcc.group_contact_content_status
FROM drs_group_contact_content gcc
WHERE gcc.group_contact_id=p_group_contact_id
AND gcc.group_contact_content_status=p_group_contact_content_status; 
  END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetGccByIdAndStatus
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetGccByIdAndStatus`(IN p_group_contact_content_id INT,IN group_contact_content_status TINYINT(1))
BEGIN
SELECT gcc.group_contact_content_id,
       gcc.recipient_email,
       gcc.recipient_action,
       gcc.group_contact_content_status
FROM drs_group_contact_content gcc
WHERE gcc.group_contact_content_id=p_group_contact_content_id
AND gcc.group_contact_content_status=group_contact_content_status;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetGccByIdWithAllStatus
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetGccByIdWithAllStatus`(IN p_group_contact_content_id INT)
BEGIN
SELECT gcc.group_contact_content_id,
       gcc.recipient_email,
       gcc.recipient_action,
       gcc.group_contact_content_status
FROM drs_group_contact_content gcc
WHERE gcc.group_contact_content_id=p_group_contact_content_id; END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetIssueTrackerByUserNameAndDate
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetIssueTrackerByUserNameAndDate`(IN p_user_name VARCHAR(50),IN p_update_time DATE,IN p_page_number INT,IN p_page_size INT,OUT p_total_records INT)
BEGIN
	
DECLARE v_start INT;
DECLARE v_total_records INT;
SET v_start =  (p_page_number-1)*p_page_size;

SET v_total_records =
(SELECT COUNT(1) FROM drs_issue_tracker i 
 WHERE i.user_name =p_user_name 
 AND DATE(i.update_time)=p_update_time AND issue_tracker_status =1);
 
SELECT v_total_records INTO p_total_records;

SELECT issue_tracker_id AS issueTrackerId,
		user_name       AS userName,
		issue_id        AS 	issueId,
        update_time     AS   updateTime
        
        FROM drs_issue_tracker i 
		WHERE i.user_name =p_user_name 
		AND DATE(i.update_time)=p_update_time 
        AND issue_tracker_status =1
        LIMIT p_page_size  OFFSET v_start;
        
		


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetListRoleByUserID
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetListRoleByUserID`(IN p_user_id INT)
BEGIN
SELECT r.role_id,
       r.role_name
FROM drs_permission p
INNER JOIN drs_role r ON p.role_id = r.role_id
WHERE p.user_id =p_user_id; 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetListTaskByReportId
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetListTaskByReportId`(IN p_report_id INT)
BEGIN
SELECT t.task_id,t.task_name,t.description,t.target_date,t.task_status,t.remark,t.task_date_defined 
FROM drs_task t 
LEFT JOIN drs_report r 
ON t.report_id=r.report_id 
WHERE t.report_id = p_report_id AND t.task_delete_status=1;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetRecipientsByReportID
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetRecipientsByReportID`(IN p_report_id INT)
BEGIN
SELECT re.report_recipient_email,
       re.report_recipient_action
FROM drs_report_recipient re
WHERE re.report_id=p_report_id
  AND re.report_recipient_status =1; 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetReportById
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetReportById`(IN p_report_id INT)
BEGIN
SELECT r.report_id,
       r.report_subject,
       r.report_type,
       r.data_etc,
       r.action_time
FROM drs_report r
WHERE r.report_id=p_report_id
AND report_status =1 ; END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetReportByUserIdAndReportType
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetReportByUserIdAndReportType`(IN p_user_id INT,IN p_report_type TINYINT(4))
BEGIN
SELECT r.report_id,
       r.report_subject,
       r.report_type,
       r.data_etc,
       r.action_time
FROM drs_report r
WHERE r.user_id =p_user_id
  AND report_type=p_report_type
  AND r.report_status =1
ORDER BY action_time DESC ; END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetReportByUserIdAndReportTypeWithPaging
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetReportByUserIdAndReportTypeWithPaging`(IN p_user_id INT,IN p_report_type INT,IN p_page_numer INT ,IN p_page_size INT,OUT p_total_record INT)
BEGIN
DECLARE v_start INT;
DECLARE v_total_records INT;
SET v_start =  (p_page_numer-1)*p_page_size;
SET v_total_records = (SELECT COUNT(1) FROM drs_report r WHERE r.user_id =p_user_id AND report_type=p_report_type AND r.report_status =1);

SELECT v_total_records INTO p_total_record;

SELECT r.report_id ,
r.report_subject ,
r.report_type ,
r.data_etc ,
r.action_time  
		FROM drs_report r 
		WHERE r.user_id =p_user_id 
		AND report_type=p_report_type
		AND r.report_status =1 
		ORDER BY action_time DESC
		LIMIT p_page_size 
		OFFSET v_start;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetTaskWithId
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetTaskWithId`(IN p_task_id INT)
BEGIN
			SELECT t.task_id,
			   t.task_name,
			   t.description,
			   t.target_date,
			   t.task_status,
			   t.remark,
			   t.remark,
			   t.task_date_defined,
			   t.task_delete_status
		FROM drs_task t
		WHERE t.task_id =p_task_id;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetTaskWithIdAndStatus
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetTaskWithIdAndStatus`(IN p_task_id INT,IN p_task_delete_status TINYINT(1))
BEGIN
SELECT t.task_id,
			   t.task_name,
			   t.description,
			   t.target_date,
			   t.task_status,
			   t.remark,
			   t.remark,
			   t.task_date_defined,
			   t.task_delete_status
		FROM drs_task t
		WHERE t.task_id =p_task_id AND t.task_delete_status=p_task_delete_status;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetUserByEmail
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetUserByEmail`(IN p_email VARCHAR(100))
BEGIN
SELECT u.user_id,
       u.user_name,
       u.email,
       u.password,
       u.full_name,
       u.status,
       u.last_password_change
FROM drs_user u
WHERE u.email =p_email; END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetUserById
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetUserById`(IN p_user_id INT)
BEGIN
SELECT u.user_id,
       u.user_name,
       u.email,
       u.password,
       u.full_name,
       u.status,
       u.last_password_change
FROM drs_user u
WHERE u.user_id =p_user_id; END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetUserByUserName
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetUserByUserName`(IN p_username VARCHAR(50))
BEGIN
SELECT u.user_id,
       u.user_name,
       u.email,
       u.password,
       u.full_name,
       u.status,
       u.last_password_change
FROM drs_user u
WHERE u.user_name =p_username; END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSGetUserInfo
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSGetUserInfo`(IN p_user_id INT)
BEGIN
SELECT u.user_name,
       u.email,
       u.full_name,
       u.last_password_change
FROM drs_user u
WHERE u.user_id=p_user_id; END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSIsGcOwner
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSIsGcOwner`(IN p_group_contact_id INT,p_user_id INT)
BEGIN
SELECT EXISTS
  (SELECT 1
   FROM drs_group_contact g
   WHERE g.group_contact_id=p_group_contact_id
     AND g.user_id=p_user_id); 
     END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSIsGccOwner
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSIsGccOwner`(IN p_group_contact_content_id INT,IN p_user_id INT,IN p_group_contact_status TINYINT(1), IN p_group_contact_content_status TINYINT(1))
BEGIN
SELECT EXISTS
  (SELECT 1
   FROM drs_group_contact gc
   RIGHT JOIN drs_group_contact_content gcc ON gc.group_contact_id = gcc.group_contact_id
   WHERE gcc.group_contact_content_id=p_group_contact_content_id
     AND gc.user_id=p_user_id
     AND gc.group_contact_status=p_group_contact_status
     AND gcc.group_contact_content_status=p_group_contact_content_status); END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSIsGccOwnerWithAllStatus
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSIsGccOwnerWithAllStatus`(IN p_group_contact_content_id INT,IN p_user_id INT)
BEGIN
SELECT EXISTS
  (SELECT 1
   FROM drs_group_contact gc
   RIGHT JOIN drs_group_contact_content gcc ON gc.group_contact_id = gcc.group_contact_id
   WHERE gcc.group_contact_content_id=p_group_contact_content_id
     AND gc.user_id=p_user_id); 
     END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSIsReportOwner
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSIsReportOwner`(IN p_user_id INT,IN p_report_type INT)
BEGIN
SELECT (EXISTS (SELECT 1 FROM drs_report r WHERE r.user_id=p_user_id AND r.report_id =p_report_type)); END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSIsTaskOwner
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSIsTaskOwner`(IN p_task_id INT, IN p_user_id INT)
BEGIN
SELECT EXISTS
  (SELECT 1
   FROM drs_task t
   LEFT JOIN drs_report r ON t.report_id=r.report_id
   WHERE t.task_id=p_task_id
     AND r.user_id =p_user_id) AS is_task_owner; 
     END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSReportFromUserByDate
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSReportFromUserByDate`(
IN p_user_id INT(11),
IN p_page INT, 
IN p_page_size INT, 
IN p_date_from Date, 
IN p_date_to Date,
OUT p_total_record INT)
BEGIN
DECLARE v_start INT;
DECLARE v_total_records INT;
SET v_start =  (p_page-1)*p_page_size;
SET v_total_records = (SELECT COUNT(1) FROM drs_report r
 WHERE r.user_id = p_user_id AND r.report_status =1 AND r.action_time BETWEEN p_date_from AND p_date_to);

SELECT v_total_records INTO p_total_record;

SELECT r.report_id ,
r.report_subject ,
r.report_type ,
r.data_etc ,
r.action_time  
		FROM drs_report r 
		WHERE r.user_id =p_user_id 
		AND r.report_status =1 
        AND r.action_time BETWEEN p_date_from AND p_date_to
		ORDER BY action_time DESC
		LIMIT p_page_size 
		OFFSET v_start;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSUpdateCustomTask
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSUpdateCustomTask`(IN p_custom_task_id INT(11),
					IN p_task_name VARCHAR(255), 
					IN p_description VARCHAR(255), 
					IN p_target_date DATE, 
					IN p_task_status INT, 
					IN p_remark TEXT)
BEGIN
		UPDATE drs_custom_task SET task_name = p_task_name, description = p_description, 
				target_date = p_target_date, task_status = p_task_status, remark= p_remark
                WHERE custom_task_id = p_custom_task_id;
	select custom_task_id, task_name, description, target_date, task_status, remark from drs_custom_task where custom_task_id = p_custom_task_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSUpdateReport
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSUpdateReport`(IN reportId INT, IN reportSubject VARCHAR(255), IN reportType TINYINT(4), IN dataEtc VARCHAR(255))
BEGIN
UPDATE drs_report
SET report_subject = reportSubject,
    report_type = reportType,
    data_etc = dataEtc
WHERE report_id = reportId;
  SELECT ROW_COUNT();
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DRSUpdateTask
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DRSUpdateTask`(
IN p_task_name TEXT, 
IN p_description TEXT, 
IN p_target_date DATE, 
IN p_status INT(11), 
IN p_remark TEXT,
IN p_task_id INT(11) )
BEGIN
UPDATE drs_task 
SET 
	task_name = p_task_name, 
    description = p_description, 
	target_date = p_target_date,
    task_status = p_status, 
	remark = p_remark 
    WHERE task_id = p_task_id;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DSRCreateGroupContact
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DSRCreateGroupContact`(IN p_group_contact_name VARCHAR(255),
																	 IN p_user_id INT, 
                                                                     OUT result INT)
BEGIN
	SET @is_user_exist = (SELECT EXISTS (SELECT 1 FROM drs_user u WHERE u.user_id =p_user_id));
    SET @new_group_contact_id =-1;
    
	IF(@is_user_exist) THEN
		INSERT INTO drs_group_contact(group_contact_name,user_id) VALUES(p_group_contact_name,p_user_id);
     SET @new_group_contact_id =(SELECT LAST_INSERT_ID() FROM DUAL );
    END IF;

	SELECT @new_group_contact_id INTO result FROM DUAL;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DSRCreateGroupContactContent
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DSRCreateGroupContactContent`(IN p_recipient_email VARCHAR(255),
																			IN p_recipient_action TINYINT(3),
																			IN p_group_contact_id INT(11),
                                                                            OUT p_group_contact_content_id INT(11))
BEGIN
-- check group contact id is exist
SET	@is_group_contact_id_exist = (SELECT EXISTS(SELECT 1 FROM drs_group_contact gc WHERE gc.group_contact_id=p_group_contact_id));
SET @is_recipient_action_valid =(SELECT EXISTS(SELECT 1 FROM DUAL WHERE p_recipient_action IN (1,2) ));
SET @new_group_contact_content_id = -1;

	IF(@is_group_contact_id_exist AND @is_recipient_action_valid ) THEN
    
		INSERT INTO drs_group_contact_content(recipient_email,recipient_action,group_contact_id) VALUES(p_recipient_email,p_recipient_action,p_group_contact_id);
			-- get group_contact_content id after insert
            SET @new_group_contact_content_id =(SELECT LAST_INSERT_ID() FROM DUAL);
    END IF;

	SELECT @new_group_contact_content_id INTO p_group_contact_content_id;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DSRCreateReport
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DSRCreateReport`(IN p_report_subject varchar(255),
															   IN p_report_type tinyint(4),
															   IN p_data_ect varchar(255),
                                                               IN p_user_id int,OUT p_report_id int)
BEGIN -- check user_id is exist in DB
SET @is_user_id_exist =
  (SELECT exists
     (SELECT 1
      FROM drs_user u
      WHERE u.user_id =p_user_id));
SET @new_report_id =-1;
IF (@is_user_id_exist) THEN
INSERT INTO drs_report(report_subject,report_type,data_etc,user_id)
VALUES(p_report_subject,
       p_report_type,
       p_data_ect,
       p_user_id); -- get last report id after insert

SET @new_report_id =(SELECT LAST_INSERT_ID() FROM DUAL); 
		END IF;
SELECT @new_report_id INTO p_report_id; END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DSRCreateReportRecipient
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DSRCreateReportRecipient`(IN p_report_recipient_email varchar(255),IN p_report_recipient_action TINYINT(3),IN p_report_id int,OUT p_report_recipient_id int)
BEGIN -- check report is exist

SET @is_report_exist =
  (SELECT exists
     (SELECT 1
      FROM drs_report r
      WHERE r.report_id =p_report_id));
SET @new_report_recipient_id = -1; if(@is_report_exist) THEN
INSERT INTO drs_report_recipient(report_recipient_email,report_recipient_action,report_id)
VALUES(p_report_recipient_email,
       p_report_recipient_action,
       p_report_id);
SET @new_report_recipient_id =
  (SELECT LAST_INSERT_ID() FROM DUAL); END IF;


SELECT @new_report_recipient_id INTO p_report_recipient_id;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DSRCreateTask
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DSRCreateTask`(IN p_task_name text, IN p_description text, IN p_target_date date, IN p_task_status int, IN p_remark text, IN p_report_id int, IN p_task_date_defined TINYINT(2), OUT p_new_task_id int)
BEGIN -- check report is exist

SET @is_report_exist =
  (SELECT exists
     (SELECT 1
      FROM drs_report r
      WHERE r.report_id =p_report_id));
SET @new_task_id = -1; if(@is_report_exist) THEN
INSERT INTO drs_task(task_name,description,target_date,task_status,remark,report_id,task_date_defined)
VALUES (p_task_name,
        p_description,
        p_target_date,
        p_task_status,
        p_remark,
        p_report_id,
        p_task_date_defined); -- get last id after inserted

SET @new_task_id =
  (SELECT LAST_INSERT_ID() FROM DUAL); END IF;


SELECT @new_task_id INTO p_new_task_id;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DSRGetCustomTaskByUserIdWithPaging
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DSRGetCustomTaskByUserIdWithPaging`(IN p_user_id INT,IN p_page_numer INT,IN p_page_size INT,OUT p_total_record INT)
BEGIN
DECLARE v_start INT;
DECLARE v_total_records INT;
SET v_start =  (p_page_numer-1)*p_page_size;
SET v_total_records = (SELECT COUNT(1) FROM drs_custom_task WHERE user_id = p_user_id AND custom_task_status = 1);

SELECT v_total_records INTO p_total_record;

SELECT custom_task_id, task_name, description, target_date, task_status, remark 
	FROM drs_custom_task 
	WHERE user_id = p_user_id 
	AND custom_task_status = 1
		LIMIT p_page_size 
		OFFSET v_start;

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DSRPagingPerQuery
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DSRPagingPerQuery`(IN p_page_number integer,IN p_size integer,out p_total_records integer,IN sql_query varchar(255))
begin
-- start location default 1
set @v_start =1 ;
-- declare v_end integer ;
set @v_total_item = 0;

set @v_start =(((p_page_number - 1) * p_size));



-- caculate number of record in table use input
set @qr =concat('select count(*) into @total_item from ( ',sql_query,' ) q');
prepare stmt from  @qr;
execute stmt;
deallocate prepare stmt;  
select @total_item into @v_total_item;

-- set value for total record found
set p_total_records=@v_total_item;



-- result of paging
set @qr2 =concat('select * from ( ',sql_query,' ) q  limit ',p_size,' offset ',@v_start);
prepare stmt from  @qr2;
execute stmt;
deallocate prepare stmt; 

end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure up_DSRUpdateTable
-- -----------------------------------------------------

DELIMITER $$
USE `internship`$$
CREATE DEFINER=`internship`@`%` PROCEDURE `up_DSRUpdateTable`(
									IN p_table_name VARCHAR(255),
									IN p_column_name VARCHAR(255),
									IN p_value VARCHAR(255),
                                    IN p_id_column_name VARCHAR(255),
                                    IN p_id_update INT,
									OUT result_update INT,
                                    OUT querys VARCHAR(255))
BEGIN
SET @p_query = CONCAT('UPDATE ',p_table_name,' SET ',p_column_name,' = ',"'",p_value,"'",' WHERE ',p_id_column_name,' = ',p_id_update);
PREPARE stmt FROM @p_query;
EXECUTE stmt;

SELECT ROW_COUNT() INTO result_update;
SELECT @p_query INTO querys;

END$$

DELIMITER ;

