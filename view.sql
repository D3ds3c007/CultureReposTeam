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
