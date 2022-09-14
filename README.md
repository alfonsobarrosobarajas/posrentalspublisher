# GCP PubSub Testing Application

## Application Setup

### PostgreSQL database
Restore sample database 'dvdrental.tar'
> $ pg_restore -U <db_user> -d pos_sales dvdrental.tar

__Configure__ 'Google Application Credentias', to GCP services Access

* Create Google Application Credentials file, on GCP:  [Google Cloud Console](https://console.cloud.google.com/ "Google Cloud Console")
* Download credentials json file
* Configure environment variables
> $ export GOOGLE_APPLICATION_CREDENTIALS=</path/to/file.json>

> $ export POS_RENTALS_CONFIG=</path/to/file.properties>

## Running application
> $ mvn spring-boot:run

or

> $ mvn clean package \
> $ java -jar target/PosRentalsPublisher<VERSION>.jar