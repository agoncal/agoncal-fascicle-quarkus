create sequence hibernate_sequence start with 1 increment by 1
create table Author (id bigint not null, bio varchar(2000), email varchar(255), first_name varchar(50), last_name varchar(255) not null, primary key (id))
create table Book (id bigint not null, description varchar(255), price float, title varchar(255), illustrations boolean, isbn varchar(255) not null, nb_Of_pages integer, primary key (id))
create table book_chapters (book_fk bigint not null, description varchar(255), title varchar(255), position integer not null, primary key (book_fk, position))
create table books_authors (book_fk bigint not null, author_fk bigint not null)
create table tags (book_fk bigint not null, value varchar(255))
alter table Book add constraint UK_bi5lx9jtv1f52idrmc0ck8ysx unique (isbn)
alter table book_chapters add constraint FKgi8b1y3ytkvvjkkf3x05b65dw foreign key (book_fk) references Book
alter table books_authors add constraint FK3gli3hxug27irvyuxbvbsqac5 foreign key (author_fk) references Author
alter table books_authors add constraint FKql7w4q5j79luv235ddxhp4g8i foreign key (book_fk) references Book
alter table tags add constraint FKmlshvl6ng7vgvn1capgjia5ag foreign key (book_fk) references Book
create sequence hibernate_sequence start with 1 increment by 1
create table Author (id bigint not null, bio varchar(2000), email varchar(255), first_name varchar(50), last_name varchar(255) not null, primary key (id))
create table Book (id bigint not null, description varchar(255), price float, title varchar(255), illustrations boolean, isbn varchar(255) not null, nb_Of_pages integer, primary key (id))
create table book_chapters (book_fk bigint not null, description varchar(255), title varchar(255), position integer not null, primary key (book_fk, position))
create table books_authors (book_fk bigint not null, author_fk bigint not null)
create table tags (book_fk bigint not null, value varchar(255))
alter table Book add constraint UK_bi5lx9jtv1f52idrmc0ck8ysx unique (isbn)
alter table book_chapters add constraint FKgi8b1y3ytkvvjkkf3x05b65dw foreign key (book_fk) references Book
alter table books_authors add constraint FK3gli3hxug27irvyuxbvbsqac5 foreign key (author_fk) references Author
alter table books_authors add constraint FKql7w4q5j79luv235ddxhp4g8i foreign key (book_fk) references Book
alter table tags add constraint FKmlshvl6ng7vgvn1capgjia5ag foreign key (book_fk) references Book
