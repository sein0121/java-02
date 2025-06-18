ALTER TABLE user
ADD COLUMN phone VARCHAR(20) NULL AFTER email,
ADD COLUMN role VARCHAR(20) NOT NULL DEFAULT 'USER' AFTER phone,
ADD COLUMN provider VARCHAR(20) NULL AFTER role,
ADD COLUMN provider_id VARCHAR(100) NULL AFTER provider,
ADD COLUMN agree_personal TINYINT(1) NOT NULL DEFAULT 0 AFTER password_hash,
ADD COLUMN updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP AFTER created_at;

-- provider : 소셜 로그인 / provider_id : 소셜 로그인 아이디 / agree_personal : 개인정보 동의 여부
