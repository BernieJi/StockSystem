# StockSystem


---可以關注自己喜歡的股票的網站---


歡迎參觀～～～

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


管理員api:


http://localhost:8081/admininfo/rawdata/{username}/giveauthority >>>根據username給予admin權限


http://localhost:8081/admininfo/rawdata/all  >>>列出系統所有使用者資訊


http://localhost:8081/admininfo/rawdata/{username}/deleteuser >>>根據username刪除使用者


使用者api:


http://localhost:8081/usersinfo/{usersname}/update  >>>根據username修改用戶資料


http://localhost:8081/usersinfo/rawdata/{usersname} >>>根據username查詢用戶資料


http://localhost:8081/usersinfo/rawdata/all >>>查詢所有用戶資訊


http://localhost:8081/usersinfo/rawdata/{usersid}/delete >>>刪除使用者


股票api:


http://localhost:8081/stockinfo/rawdata/{stockcode}/{username}/addtowatchlist >>>根據stockcode與username將股票加入個人追蹤清單


http://localhost:8081/stockinfo/rawdata/{stockcode} >>> 根據stockcode查詢股票資訊


http://localhost:8081/stockinfo/rawdata/all >>> 查詢所有股票資訊


http://localhost:8081/stockinfo/rawdata/{stockcode}/delete >>>刪除股票

關注列表api:


http://localhost:8081/watchlistinfo/rawdata/all >>>查詢所有關注列表資訊


http://localhost:8081/watchlistinfo/rawdata/delete/{username}/{stockcode} >>>根據username刪除關注列表中的stock






