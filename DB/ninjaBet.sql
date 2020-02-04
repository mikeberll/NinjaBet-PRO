CREATE TABLE `users` (
  `id_u` integer PRIMARY KEY,
  `username` varchar(255),
  `inserted_at` timestamp
);

CREATE TABLE `accounts` (
  `id_a` integer PRIMARY KEY,
  `id_u` integer,
  `id_ws` integer,
  `inserted_at` timestamp,
  `cash` double
);

CREATE TABLE `website` (
  `id_ws` integer PRIMARY KEY,
  `name` varchar(255)
);

CREATE TABLE `bank_account` (
  `id_b` integer PRIMARY KEY,
  `id_u` integer,
  `cash` double
);

CREATE TABLE `deposit` (
  `id_d` integer,
  `id_a` integer,
  `id_b` integer,
  `cash` double
);

CREATE TABLE `bet` (
  `id_bet` integer,
  `id_acc1` integer,
  `id_acc2` integer,
  `cash1` double,
  `cash2` double,
  `win1` double,
  `win2` double,
  `winner` boolean
);

ALTER TABLE `accounts` ADD FOREIGN KEY (`id_u`) REFERENCES `users` (`id_u`);

ALTER TABLE `accounts` ADD FOREIGN KEY (`id_ws`) REFERENCES `website` (`id_ws`);

ALTER TABLE `bank_account` ADD FOREIGN KEY (`id_u`) REFERENCES `users` (`id_u`);
