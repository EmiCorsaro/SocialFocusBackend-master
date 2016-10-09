echo "------------levanto maven-----------------"
mvn clean install
echo "------------buildeando docker-------------"
sudo docker build -t bsa .
echo "------------run docker--------------------"
sudo docker run --link mongo:mongo    -t -i -p 8080:8080 bsa

