#Clone the project:

git clone https://github.com/deepaknigam2702/mobiquity-assignment.git mobiquity-assignment

# Go to the root of the project:

cd mobiquity-assignment 

# Run the application:

mvn spring-boot:run

# To get list of atm run the following curl command:
curl -XGET http://localhost:8080/atms

# To get list of atm of a particular city run the following curl command:
curl -XGET http://localhost:8080/atms/{city}

For exmample:
curl -XGET http://localhost:8080/atms/Spaarndam


#Possible improvements in the project
1) APIs can be made secure for controlled access
2) Data can be persisted into database instead of a plain text file
3) A scheduler can be used to frequently update the data from the source
4) More JUnit test cases can be added
