#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>
#include <string.h>
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
char personid[13]={'\0'};

int led = D0;
int pflag=0;
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
  a:if(Serial.available()>=12)
  {
    char rfid[13];
    int i;
    for(i=0;i<=11;i++)
      rfid[i]=Serial.read();
    
    rfid[12]='\0';
    
    Serial.println(rfid);
    while(Serial.available()>0) Serial.read();
    String testcard=String(rfid);
    if(strcmp(personid,rfid)!=0 && pflag==0) 
    {
      Serial.println("In first if");
      strcpy(personid,rfid);
      pflag=1;
      goto a;
    }
    else if(strcmp(personid,rfid)==0 && pflag==1)
    {
      for(int k=0;k<13;k++)
        personid[k]='\0';
      Serial.print("Person ID after clearing: ");
      Serial.println(personid);
      pflag=0;
    }
    else 
    {
      digitalWrite(pstatus,LOW);
      Serial.print("Person ID:");
      Serial.println(personid);
      
      String pid = String(personid);
      Serial.print("PID: ");
      Serial.print(pid);
      Serial.print("\t");
      Serial.println(testcard);
       String vv="/1/";
      String url = "http://192.168.43.224:8082/messanger/webapi/transections/"+String(testcard)+String(vv)+String(pid)+" ";  // Change the url here according to the IP configuration. 
      //String url1 = "http://192.168.43.224:8082/messanger/webapi/transections/3C001733CCD4/1/1234567811";
      Serial.println(url);
      http.begin(url);
      http.GET();
      http.end();
      Serial.println("POSTED");
      digitalWrite(pstatus,HIGH);
    }
    delay(1500);
  }
}
