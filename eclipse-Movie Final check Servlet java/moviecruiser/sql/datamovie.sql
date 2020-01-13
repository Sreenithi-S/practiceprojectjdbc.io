/* inserting data to movies*/

INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('101 ', 'Avatar', '$2,787,965,087', 'yes', '2019-03-15', 'science_fiction', 'yes');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('102', 'The Avengers', '$1,518,812,988', 'yes', '2020-01-04', 'Super hero', 'yes');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('103', 'Titanic', '$2,187,463,944', 'yes', '2021-03-15', 'Romance', 'no');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('104', 'Jurassic world', '$1,617,713,201', 'no', '2020-02-02', 'Science Fiction', 'yes');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('105', 'Avengers:End game', '$2,759,760,348', 'yes', '2020-05-01', 'Super hero', 'yes');

/*inserting data to user*/
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Surya');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Karthik');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('3', 'Arjun');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('4', 'Ashwin');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('5', 'Ragu');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('6', 'Annie');

/*insert data to favorites*/

INSERT INTO `moviecruiser`.`favorites` (`fs_id`, `fs_us_id`, `fs_mo_id`) VALUES ('1', '6', '103');
INSERT INTO `moviecruiser`.`favoritse` (`fs_id`, `fs_us_id`, `fs_mo_id`) VALUES ('2', '1', '102');
INSERT INTO `moviecruiser`.`favorites` (`fs_id`, `fs_us_id`, `fs_mo_id`) VALUES ('3', '2', '104');

/*--1.	View Movies list Admin (TYUC001)*/

select mo_id,mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movies

/*2.	View Menu Item List Customer (TYUC002)*/

select mo_title ,mo_box_office, mo_date_of_launch, mo_genre, mo_has_teaser from moviecruiser.movies where mo_active='yes' and mo_date_of_launch>(select curdate());

update moviecruiser.movies
set
mo_title='babys day out',
mo_box_office='4586438754',
mo_date_of_launch='2020-10-10',
mo_genre='entertainment',
mo_has_teaser='yes'
where mo_id='102'

select fs_id,fs_mo_id, fs_us_id from moviecruiser.favorites
select count(mo_id) as no_of_favorites  from moviecruiser.movies 
inner join moviecruiser.favorites
on fs_mo_id=mo_id where fs_us_id=1;
/*SQL query to remove a movies from favoritse based on User Id and Movies Id*/
delete from moviecruiser.favorites where fs_us_id=2 and fs_mo_id='104';

