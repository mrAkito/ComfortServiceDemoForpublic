CREATE TABLE weather (
  id SERIAL NOT NULL,
  temp integer,
  humid integer,
  pressure integer,
  comfort integer,
  deal_flg boolean,
  del_flg boolean,
  date timestamp,
  PRIMARY KEY (id)
);