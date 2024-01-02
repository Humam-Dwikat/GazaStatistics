#GazaStatistics 
======================
## overview
new backend feature for an application similar to social media websites
such as Twitter or LinkedIn. The motivation behind this feature is a new rule enacted by the Gaza authority ,
allowing users to manage and access the collected information about themselves.
we have added feature called User Data .
this feature has two parts
-Export data: in this feature the user can download their data directly or upload it to the storage file

-Delete Data: in this feature the user have two types of delete:
    - soft delete: delete all the info about the user except the profile data
    - hard delete: delete all info about user

## how we implemented the project
first of all, we have separated the project into small parts to be able to act with the components as independent,
by talking about the export data: if we want to download data we need to get data from the service and convert 
the data to a PDF file as per the provided requirements this is choice number one(Direct download ), 
and choice number two is (uploading the data to storage file)such as(DropBox, Google Drive ...etc.)
so we need to get the data from the service and convert the data to a PDF file as we did in choice 
number one then connect to the storage file service and upload the file.
talking about the Delete data: we need to connect with the services 
and delete the data based on the delete type as we mentioned above(soft delete, hard delete).

## what we use in the project
we use a 
##### factory design patter:
determine what kind of data you want to get or add
#### strategy design patter:
use with "Collect data"  same function but a different behavior
#### Template design patter:
determine how can the user delete data
#### Log4j :
for create a logger in the project
#### itext: 
for create a PDF file 
#### zip : 
for create a ZIP file






