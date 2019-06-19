-- create USER table
CREATE TABLE IF NOT EXISTS T_USER (
  id                  BIGSERIAL NOT NULL PRIMARY KEY,
  username            VARCHAR(64),
  email               VARCHAR(64),
  password            VARCHAR(64),
  created_ts          TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
  updated_ts          TIMESTAMP WITH TIME ZONE,
  created_by_user     VARCHAR(32) NOT NULL DEFAULT 'System',
  updated_by_user     VARCHAR(32),
  CONSTRAINT unique_username_email UNIQUE(username, email)
);

-- create EVENT_TYPE table
CREATE TABLE IF NOT EXISTS T_EVENT_TYPE (
  id                  BIGSERIAL NOT NULL PRIMARY KEY,
  name                VARCHAR(64),
  description         VARCHAR(128),
  created_ts          TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
  updated_ts          TIMESTAMP WITH TIME ZONE,
  created_by_user     VARCHAR(32) NOT NULL DEFAULT 'System',
  updated_by_user     VARCHAR(32)
);

-- create EVENT table
CREATE TABLE IF NOT EXISTS T_EVENT (
  id                  BIGSERIAL NOT NULL PRIMARY KEY,
  name                VARCHAR(64),
  description         VARCHAR(256),
  location            VARCHAR(128),
  start_date          TIMESTAMP WITH TIME ZONE,
  end_date            TIMESTAMP WITH TIME ZONE,
  event_type_id       BIGSERIAL NOT NULL REFERENCES T_EVENT_TYPE(id),
  created_ts          TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
  updated_ts          TIMESTAMP WITH TIME ZONE,
  created_by_user     VARCHAR(32) NOT NULL DEFAULT 'System',
  updated_by_user     VARCHAR(32)
);

-- create NOTIFICATION table
CREATE TABLE IF NOT EXISTS T_NOTIFICATION (
  id                  BIGSERIAL NOT NULL PRIMARY KEY,
  name                VARCHAR(64),
  event_id            BIGSERIAL NOT NULL REFERENCES T_EVENT(id),
  created_ts          TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
  updated_ts          TIMESTAMP WITH TIME ZONE,
  created_by_user     VARCHAR(32) NOT NULL DEFAULT 'System',
  updated_by_user     VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS T_USER_EVENT (
  id                  BIGSERIAL NOT NULL PRIMARY KEY,
  user_id             BIGSERIAL NOT NULL REFERENCES T_USER(id),
  event_id            BIGSERIAL NOT NULL REFERENCES T_EVENT(id),
  created_ts          TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
  updated_ts          TIMESTAMP WITH TIME ZONE,
  created_by_user     VARCHAR(32) NOT NULL DEFAULT 'System',
  updated_by_user     VARCHAR(32),
  CONSTRAINT unique_user_id_event_id UNIQUE(user_id, event_id)
);