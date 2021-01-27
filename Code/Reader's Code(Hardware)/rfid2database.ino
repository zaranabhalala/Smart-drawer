#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>

#include <ESP8266HTTPClient.h>
#include <ESP8266httpUpdate.h>


ESP8266WiFiMulti WiFiMulti;
HTTPClient http;


/*
 * Just change the SSID and Password here for the new network. 
 * SSID: the name of hotspot
 * Password: the password of the mobile hotspot.
 * 
 * */
const char* ssid = "nnnn";
const char* password = "09876543";

String card1 = "1800895A5E95";
String card2 = "1800896DB34F";

int led = D0;
int pstatus = D4;
void setup_wifi()
{
    Serial.println();
    Serial.print("Connecting to Network...");
    Serial.println(ssid);
    WiFi.begin(ssid,password);

    while(WiFi.status() != WL_CONNECTED)
    {
      delay(500);
      Serial.print(".");
      digitalWrite(led,HIGH);
    }
    Serial.println("");
    Serial.println("WiFi connected");
    digitalWrite(led,LOW);
    Serial.println("IP address: ");
    Serial.println(WiFi.localIP());
}

void setup() {
  // put your setup code here, to run once:
 Serial.begin(9600);
 pinMode(led,OUTPUT);
 digitalWrite(led,HIGH);
 pinMode(pstatus,OUTPUT);
 digitalWrite(pstatus,HIGH);
 setup_wifi();
}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available()>=12)
  {
    char rfid[13];
    int i;
    for(i=0;i<=11;i++)
      rfid[i]=Serial.read();
    
    rfid[12]='\0';
    
    Serial.println(rfid);
    while(Serial.available()>0) Serial.read();
    String testcard=String(rfid);
    digitalWrite(pstatus,LOW);
    String url = "http://192.168.43.224:8082/messanger/webapi/transections/"+testcard+"/1";  // Change the url here according to the IP configuration. 
    Serial.println(url);
    http.begin(url);
    http.GET();
    http.end();
    Serial.println("POSTED");
    digitalWrite(pstatus,HIGH);
  }
}
