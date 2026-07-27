SELECT country,
       'Vaccinated' AS coverage_type,
       SUM(vaccinated_population) AS population_count
FROM vaccination_data
GROUP BY country

UNION

SELECT country,
       'Unvaccinated' AS coverage_type,
       SUM(population - vaccinated_population) AS population_count
FROM vaccination_data
GROUP BY country;
