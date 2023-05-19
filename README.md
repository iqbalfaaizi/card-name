# generate-card-name



## Getting started
* Jago nonprod VPN
* Run App

This curl to generate multiple emboss name examples from ms-card & customer
```
curl --location 'http://localhost:8080/card/generateEmbossName'
```

To truncate long name (<24 chars) use 
```
curl --location 'http://localhost:8080/card/generateName' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Lorem Ipsum Dolor Sit Amet Consectetur"
}'
```