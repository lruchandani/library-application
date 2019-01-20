create table subscriptions.subscription(
subscription_id varchar(50) not null,
user_id varchar(50) not null,
book_id varchar(50) not null,
issue_date datetime not null,
due_date datetime not null,
return_date datetime,
status varchar(1) not null,
primary key (subscription_id)
)