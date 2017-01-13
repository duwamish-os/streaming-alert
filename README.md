streaming alert 
 ----------------------
 
 - flume is streaming api with capabilities of sending the events to 
 multiple backend datastores like file, elasticsearch etc
 
 - `EventNotifier` is an api to send alerts to business people or devs
 if any kind of events are consumed from a log file, or whatever source
 even before writing to the backend data stores.
 
 - currently it sends alerts to `#slack-channel`
 
 uses
 ----
 
 ```
  16 client.sources.source_1.interceptors = alertBusinessPeople
  18 client.sources.source_1.interceptors.alertBusinessPeople.regex = .*error.*
  19 client.sources.source_1.interceptors.alertBusinessPeople.toChannel = "#application-interuptions"
 ```
 
 TODO
 ------
 
 ```
   client.sources.source_1.interceptors = alertBusinessPeople
   client.sources.source_1.interceptors.alertBusinessPeople.regex = .*error.*
   client.sources.source_1.interceptors.alertBusinessPeople.from = "myapp@business.com"
   client.sources.source_1.interceptors.alertBusinessPeople.toChannel = "alert@business.com"
 ```