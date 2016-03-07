# tarea1Arquitectura

#Comandos importantes

alter table venta drop foreign key venta_ibfk_1;
alter table vehiculo modify column vehiculoId int auto_increment;
alter table venta add foreign key(vehiculoId) references Vehiculo(vehiculoId);
