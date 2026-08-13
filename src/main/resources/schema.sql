-- 1. Monta a lista de comandos com ponto e vírgula ao final de cada instrução
SET @sql = NULL;

SELECT GROUP_CONCAT(CONCAT('ALTER TABLE `', table_name, '` AUTO_ID_CACHE = 1;') SEPARATOR ' ')
INTO @sql
FROM information_schema.tables
WHERE table_schema = DATABASE() AND table_type = 'BASE TABLE';

-- 2. Evita erro caso não exista nenhuma tabela
SET @sql = IFNULL(@sql, 'SELECT 1;');

-- 3. Prepara e executa todos os ALTER TABLE de uma só vez
PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;