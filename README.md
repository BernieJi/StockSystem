# StockSystem

＊＊＊＊將專案部署至Azure: ＊＊＊＊

1. Create a Java app

首先啟動 Azure Cloud Shell：

git clone https://github.com/BernieJi/StockSystem

cd StockSystem/SpringProject

2. Configure the Maven plugin:


mvn com.microsoft.azure:azure-webapp-maven-plugin:2.5.0:config


3. Deploy the app:

mvn package azure-webapp:deploy

成功後即可在 http://{appName}.azurewebsites.net/ 顯示出Java app內容


＊＊＊＊Swagger URL 說明＊＊＊＊
主要分成四個部分： 管理員 . 使用者 . 股票 . 追蹤清單
