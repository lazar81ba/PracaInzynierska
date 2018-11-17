CREATE TABLE IF NOT EXISTS public.specialization
(
  id serial not null
    constraint specialization_pkey
    primary key,
  name varchar(255) not null unique
);

CREATE TABLE IF NOT EXISTS public.country
(
  id serial not null
    constraint country_pkey
    primary key,
  name varchar(255) not null unique
);

CREATE TABLE IF NOT EXISTS public.tag
(
  id serial not null
    constraint tag_pkey
    primary key,
  name varchar(255) not null unique
);

CREATE TABLE IF NOT EXISTS public.link
(
  id serial not null
    constraint link_pkey
    primary key,
  address text not null unique
);

CREATE TABLE IF NOT EXISTS public.faculty
(
  id serial not null
    constraint faculty_pkey
    primary key,
  name varchar(1024) not null,
  id_university integer not null
);

CREATE TABLE IF NOT EXISTS public.faculty_specialization
(
  id serial not null
    constraint faculty_specialization_pkey
    primary key,
  id_faculty integer not null,
  id_specialization integer not null
);

CREATE TABLE IF NOT EXISTS public.university
(
  id serial not null
    constraint university_pkey
    primary key,
  name varchar(1024) not null unique,
  id_country integer not null
);

CREATE TABLE IF NOT EXISTS public.communicator
(
  id serial not null
    constraint communicator_pkey
    primary key,
  id_from_user integer not null,
  id_to_user integer not null,
  message_date timestamp not null,
  content text not null
);

CREATE TABLE IF NOT EXISTS public.project_tag
(
  id serial not null
    constraint project_tag_pkey
    primary key,
  id_project integer not null,
  id_tag integer not null
);

CREATE TABLE IF NOT EXISTS public.project_link
(
  id serial not null
    constraint project_link_pkey
    primary key,
  id_project integer not null,
  id_link integer not null
);


CREATE TABLE IF NOT EXISTS public.project_details
(
  id serial not null
    constraint project_details_pkey
    primary key,
  id_project integer not null,
  content varchar(255) not null
);


CREATE TABLE IF NOT EXISTS public.project
(
  id serial not null
    constraint project_pkey
    primary key,
  name varchar(255) not null,
  description text not null,
  image_url text not null,
  public boolean not null,
);

CREATE TABLE IF NOT EXISTS public.project_user
(
  id serial not null
    constraint project_user_pkey
    primary key,
  id_project integer not null,
  id_user integer not null
);

CREATE TABLE IF NOT EXISTS public.observable
(
  id serial not null
    constraint observable_pkey
    primary key,
  id_project integer not null,
  id_user integer not null
);

CREATE TABLE IF NOT EXISTS public.user
(
  id serial not null
    constraint user_pkey
    primary key,
  name varchar(255) not null,
  surname varchar(255) not null,
  password text not null unique,
  email varchar(255) not null unique,
  id_university integer not null,
  id_faculty integer not null,
  id_specialization integer not null,
  image_url text not null,
  sex varchar(6) not null
);

ALTER TABLE public.faculty_specialization ADD CONSTRAINT specialization_fkey FOREIGN KEY (id_specialization) REFERENCES public.specialization(id) ;
ALTER TABLE public.faculty_specialization ADD CONSTRAINT faculty_fkey FOREIGN KEY (id_faculty) REFERENCES public.faculty(id) ;
ALTER TABLE public.faculty ADD CONSTRAINT faculty_university_fkey FOREIGN KEY (id_university) REFERENCES public.university(id) ;
ALTER TABLE public.university ADD CONSTRAINT university_country_fkey FOREIGN KEY (id_country) REFERENCES public.country(id) ;
ALTER TABLE public.communicator ADD CONSTRAINT from_user_fkey FOREIGN KEY (id_from_user) REFERENCES public.user(id) ;
ALTER TABLE public.communicator ADD CONSTRAINT to_user_fkey FOREIGN KEY (id_to_user) REFERENCES public.user(id) ;
ALTER TABLE public.user ADD CONSTRAINT user_university_fkey FOREIGN KEY (id_university) REFERENCES public.university(id) ;
ALTER TABLE public.user ADD CONSTRAINT user_faculty_fkey FOREIGN KEY (id_faculty) REFERENCES public.faculty(id) ;
ALTER TABLE public.user ADD CONSTRAINT user_specialization_fkey FOREIGN KEY (id_specialization) REFERENCES public.specialization(id) ;
ALTER TABLE public.project_user ADD CONSTRAINT user_fkey FOREIGN KEY (id_user) REFERENCES public.user(id) ;
ALTER TABLE public.project_user ADD CONSTRAINT project_fkey FOREIGN KEY (id_project) REFERENCES public.project(id) ;
ALTER TABLE public.observable ADD CONSTRAINT observable_user_fkey FOREIGN KEY (id_user) REFERENCES public.user(id) ;
ALTER TABLE public.observable ADD CONSTRAINT observable_project_fkey FOREIGN KEY (id_project) REFERENCES public.project(id) ;
ALTER TABLE public.project_details ADD CONSTRAINT project_details_fkey FOREIGN KEY (id_project) REFERENCES public.project(id) ;
ALTER TABLE public.project_link ADD CONSTRAINT link_fkey FOREIGN KEY (id_link) REFERENCES public.link(id) ;
ALTER TABLE public.project_link ADD CONSTRAINT project_link_fkey FOREIGN KEY (id_project) REFERENCES public.project(id) ;
ALTER TABLE public.faculty_specialization ADD UNIQUE (id_faculty, id_specialization);
ALTER TABLE public.project_tag ADD UNIQUE (id_project, id_tag);
ALTER TABLE public.project_link ADD UNIQUE (id_project, id_link);
ALTER TABLE public.project_user ADD UNIQUE (id_project, id_user);
ALTER TABLE public.observable ADD UNIQUE (id_project, id_user);

