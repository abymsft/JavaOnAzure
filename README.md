# javaonazure
### Playing around with a 'Hello World' Spring Boot MVC hosted on an Azure WebApps, Linux App Service plan

### Prerequisites
 - Azure subscription
 - Basic knowledge of Azure cloud shell
 - Deployed Azure webapp hosted on a linux app service plan
 - Application insight instance linked to the web app
 - A spring mvc app

### Dependancies
>Reuse the POM.xml file as is for all dependecies. Make sure to change the resource names mentioned under the "*azure-webapp-maven-plugin*"
#### Logging DEBUG, INFO and ERROR events for a Linux based Java Azure WebApp/API using application insights
  > Navigate to controller [class](https://github.com/abymsft/javaonazure/blob/master/src/main/java/com/monitoring/azuremonitor/HelloController.java)
#### Install the application insights agent to you azure java app. 
  > Download the latest version of the [applicationinsights-agent-X.X.X.jar](https://github.com/Microsoft/ApplicationInsights-Java/releases/tag/2.5.1) and publish the jar inside the wwwroot folder of your Azure WebApp
  
#### Inside java solution, resources folder
 - Add [AI-Agent.xml](https://github.com/abymsft/javaonazure/blob/master/src/main/resources/AI-Agent.xml). More info [here](https://docs.microsoft.com/en-us/azure/azure-monitor/app/java-agent)
  - Add [application.properties](https://github.com/abymsft/javaonazure/blob/master/src/main/resources/application.properties). More info [here](https://docs.microsoft.com/en-us/azure/azure-monitor/app/java-get-started?tabs=maven)
  - Add [log4j2.xml](https://github.com/abymsft/javaonazure/blob/master/src/main/resources/log4j2.xml). This appends log4j events to ApplicationInsights 'traces' table.


### *App Configuration settings* 
- Open the Azure cloud shell and use the below cli command
```sh
az webapp config appsettings set -g resroucegroupname -n uniqueappname --settings 'JAVA_OPTS=-javaagent:/home/site/wwwroot/applicationinsights-agent-X.X.X.jar'
```
