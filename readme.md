Clone Project
-------------
git clone https://github.com/Raushan250/Prizy-Pricer.git

It is built using Spring Tool Suite and Spring boot version 2.
It is running correctly in my local.If you are getting error.

Please make sure you are ruuning this in STS with spring boot 2.
Because I have tested this only in STS.


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
curl -v -X GET http://localhost:8080/product/getProductPriceDetails/B1234 



