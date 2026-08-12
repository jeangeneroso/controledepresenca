-- Aplica AUTO_ID_CACHE = 1 em todas as tabelas do banco automaticamente
SET @sql = NULL;
SELECT GROUP_CONCAT(CONCAT('ALTER TABLE `', table_name, '` AUTO_ID_CACHE = 1') SEPARATOR '; ')
INTO @sql
FROM information_schema.tables
WHERE table_schema = DATABASE();

SET @sql = IFNULL(@sql, 'SELECT 1');
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;