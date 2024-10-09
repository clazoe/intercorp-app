# Aplicacion Customer care - Intercorp
Proyecto que contiene las aplicaciones

customercare-backend : 
microservicios con las siguientes apis:
(![postman](customercare-backend/docs/intercorp-customer-care.postman_collection.json)

customercare-frontend :
Proyecto en angular con Forms reactivos y Angular Material

# Diagrama de Infraestrura provisionado en la nube AWS
Recuros usados:
S3 : para desplegar la aplicacion angular
AWS Application Load Balancer balancea la carga de las instancias
Relational Database Service: se despliega la base de datos Mysql
Elastic Container Registry (ECR) : almanecena la imagen docker del microservicio customercare-backend
Elastic Container Registry:
- Se crea un cluster fargate
- Se crea un task para el microservico
- Se crea un task para el balanceo de carga

![infraestructura-aws](customercare-backend/docs/aws-infraestructure-customercare.jpg)
