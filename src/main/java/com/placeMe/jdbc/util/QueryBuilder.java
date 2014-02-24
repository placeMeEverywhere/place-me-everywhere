package com.placeMe.jdbc.util;

public class QueryBuilder {

	public static final String USER_CHECK 						= 	"SELECT * " +
																	"FROM user " +
																	"WHERE email=:email";
	
	public static final String COUNTRY_CHECK					=   "SELECT count(*) " +
																	"FROM country " +
																	"WHERE country_name = :countryName";

	public static final String AREA_CHECK						=   "SELECT count(*) " +
																	"FROM administrative_area_level_1 " +
																	"WHERE area_name = :areaName";

	public static final String LOCATION_CHECK					=   "SELECT count(*) " +
																	"FROM location " +
																	"WHERE location_name = :locationName";

	public static final String COUNTRY_SELECT					=	"SELECT * " +
																	"FROM country " +
																	"WHERE country_name = :countryName";

	public static final String AREA_SELECT						=	"SELECT * " +
																	"FROM administrative_area_level_1 " +
																	"WHERE area_name = :areaName";

	
	public static final String COUNTRY_INSERT					=	"INSERT INTO country " +
																	"VALUES(:id, :countryName)";
	
	public static final String AREA_INSERT						=	"INSERT INTO administrative_area_level_1 " +
																	"VALUES(:id, :areaName, :idCountry)";

	public static final String LOCATION_INSERT					=	"INSERT INTO location " +
																	"VALUES(:id, :locationName, :idArea)";
	
	
	public static final String ALL_LOCATIONS					=	"SELECT l.location_name, a.area_name, c.country_name " +
																	"FROM location l, administrative_area_level_1 a, country c " +
																	"WHERE l.id_area = a.id " +
																	"AND a.id_country = c.id";

}
