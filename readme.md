Clone Project
-------------
git clone https://github.com/Raushan250/Prizy-Pricer.git


App Usage
---------
cd demo <br>
mvn clean install <br>


Save Product
-------------
curl -v -X POST http://localhost:8080/product/create/Z14678/180/prizyStrore

see the save data
curl -v -X GET http://localhost:8080/product/getProductPriceDetails/Z14678 



Store Price For Product
------------------------
curl -v -X PUT http://localhost:8080/product/update/Z14678/200/prizyStrore

see the updated idealPrice

curl -v -X GET http://localhost:8080/product/getProductPriceDetails/Z14678


GET Product
------------
curl -v -X GET http://localhost:8080/product/1


Get Survey Data
----------------
curl -v -X GET http://localhost:8080/productSurvey/1


Get Price Details
-----------------

http://localhost:8080/getProductPriceDetails/barcode <br>
curl -v -X GET http://localhost:8080/product/getProductPriceDetails/B1234 



