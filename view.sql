CREATE VIEW simulation_details_view AS
SELECT s.id_simulation, sd.id_details, a.name as action_name, sd.quantity, sd.price
FROM simulation s
JOIN plot p ON s.id_plot = p.id_plot
JOIN simulation_details sd ON s.id_simulation = sd.id_simulation
JOIN action a ON sd.id_action = a.id_action;

CREATE VIEW last_three_activities_view AS
SELECT s.id_simulation, p.id_plot, sd.id_details, a.name as action_name, sd.quantity, sd.price, s.date_simulation
FROM simulation s
JOIN plot p ON s.id_plot = p.id_plot
JOIN simulation_details sd ON s.id_simulation = sd.id_simulation
JOIN action a ON sd.id_action = a.id_action
ORDER BY p.id_plot, s.date_simulation DESC;


JOIN ground_type g on g.id_ground_type=p.id_ground_type
JOIN culture c on c.id_ground_type=g.id_ground_type


CREATE VIEW avg_yield_per_culture_per_plot_view AS
SELECT p.id_plot,s.id_culture,c.name AS culture_name, avg(y.quantity)/p.area as avg_yield
FROM plot p
JOIN simulation s on s.id_plot=p.id_plot
JOIN culture c on c.id_culture=s.id_culture
JOIN yield y on y.id_simulation=s.id_simulation
group by p.id_plot,s.id_culture,c.name;