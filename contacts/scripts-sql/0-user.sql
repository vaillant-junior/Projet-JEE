

-- Supprime le schéma contacts

DROP SCHEMA IF EXISTS contacts CASCADE;


-- Crée l'utilisateur contacts
-- (après l'avoir supprimé au préalable s'il existait déjà)

DO $code$
BEGIN
	IF EXISTS (SELECT  FROM pg_catalog.pg_roles WHERE rolname  = 'contacts')
	THEN
		REVOKE CREATE ON DATABASE postgres FROM contacts;
		DROP USER contacts;
	END IF;
END
$code$;

CREATE USER contacts WITH PASSWORD 'contacts';
GRANT CREATE ON DATABASE postgres TO contacts;

