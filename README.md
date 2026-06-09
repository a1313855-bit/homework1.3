# 🎮 Java 猜拳賭博遊戲 (Rock Paper Scissors Betting Game)

使用 **Java 物件導向(OOP)** 製作的猜拳賭博遊戲，包含 **Console 版本** 與 **Swing GUI 圖形介面版本**。

## 📌 專案介紹

玩家一開始擁有 **1000 元資金**，每回合可以自由下注金額，再與電腦進行猜拳：

* 布 (0)
* 剪刀 (1)
* 石頭 (2)

勝利可獲得下注金額，失敗則扣除下注金額，平手金額不變。

當資金歸零時，遊戲結束(Game Over)。

---

## ✨ 功能特色

### Console 版

* 玩家名稱設定
* 下注金額檢查
* 猜拳對戰
* 勝負判斷
* 金額計算
* 破產自動結束遊戲

---

### Swing GUI 版

* 圖形化介面
* 即時時間顯示
* 玩家名稱登入
* 下注功能
* RadioButton 選擇出拳
* 電腦隨機出拳
* 對戰結果顯示
* 金額更新
* 回合紀錄
* 清空紀錄
* 列印紀錄
* 離開程式
* 玩家破產後自動鎖定所有操作按鈕

---

## 📂 專案結構

```
src/
│
├── game/
│   ├── A/
│   │     Rule.java
│   │
│   ├── B/
│   │     Player.java
│   │     Cpu.java
│   │
│   └── C/
│         Add.java
│         AddUi.java
```

### Rule.java

負責：

* 猜拳規則
* 勝負判斷
* 手勢轉換
* 回傳結果

### Player.java

負責：

* 玩家名稱
* 玩家金額
* 下注金額
* 金額計算

### Cpu.java

負責：

* 電腦出拳資料

### Add.java

Console 版本主程式。

### AddUi.java

Swing GUI 圖形介面版本。

---

## 🛠 使用技術

* Java
* Java OOP
* Eclipse
* Swing GUI
* Random API
* Timer
* Event Listener
* JTextArea
* JScrollPane
* JRadioButton

---

## 🚀 執行方式

### Console 版

執行：

```
Add.java
```

即可使用終端機進行遊戲。

---

### GUI 版

執行：

```
AddUi.java
```

即可開啟 Swing 視窗進行遊戲。

---

## 📸 遊戲流程

1. 輸入玩家名稱
2. 開始遊戲
3. 輸入下注金額
4. 選擇出拳
5. 電腦隨機出拳
6. 判斷勝負
7. 更新金額
8. 繼續下一局或直到破產

---

## 🎯 學習重點

本專案練習了：

* Java 基礎語法
* 類別(Class)設計
* 繼承(Inheritance)
* Getter / Setter
* 物件導向程式設計(OOP)
* Random 隨機數
* Swing GUI 開發
* Event Listener 事件處理
* 按鈕控制
* 遊戲流程設計
* 狀態控制(Game Running)

---

## 👨‍💻 Author

GitHub Project by **推し【雪民】雪花ラミィ**

Java Practice Project

