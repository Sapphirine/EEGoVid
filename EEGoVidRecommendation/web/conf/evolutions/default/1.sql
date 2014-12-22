# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table videos (
  id                        bigint not null,
  name                      varchar(255),
  length                    float,
  cover_image               varchar(255),
  feature_image             varchar(255),
  feature                   varchar(255),
  constraint pk_videos primary key (id))
;

create sequence videos_seq;




# --- !Downs

drop table if exists videos cascade;

drop sequence if exists videos_seq;

