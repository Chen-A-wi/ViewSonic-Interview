# ViewSonic-Interview
此專案主要是For ViewSonic的小作業，實作SpaceX發射資料，下面是Demo畫面👇。

| Loading  | All Launches |
| ------------- | ------------- |
|<img src= "https://user-images.githubusercontent.com/24693300/182912432-6c1b9691-57a0-4cbc-a52c-0f30180ebef3.png" width="360" height="720" /> | <img src= "https://user-images.githubusercontent.com/24693300/182912611-8c054cd2-38fc-48ff-b9b9-c488e53be904.png" width="360" height="720" />  |

| Switch | No Internet |
| ------------- | ------------- |
| <img src= "https://user-images.githubusercontent.com/24693300/182912923-d58adeef-e7a2-4bfc-bf54-49fd612715c5.png" width="360" height="720" /> | <img src= "https://user-images.githubusercontent.com/24693300/182912757-4e199077-5a56-42d5-a34c-b636d3ab3657.png" width="360" height="720" />  |

| Launch Detail |
| ------------- |
| <img src= "https://user-images.githubusercontent.com/24693300/182913129-3a9f2f56-9b15-44a1-93b3-dd3ad2476516.png" width="360" height="720" /> | 

## Feature List
- [x] 使用 Kotlin 以及 Android Architecture Component 的元件。
- [x] 以 MVVM 為架構設計。
- [x] 使用 RecyclerView 實作清單列表。
- [x] 點擊 Flightnumber: oldest 跳出排序選項。
- [x] 列表可依 FlightNumber 排序(大到小/小到大)。
- [x] 點擊清單可進入 Launch Detail 頁面。
- [x] 使用 Fragment 實作 LaunchDetail 頁面。
- [x] 專案完成後請上傳到 GitHub 或者 GitLab。

### Bonus
- [x] 以 CleanCode 思維來實作專案。
- [ ] UnitTestandUItest(Espresso)。

## Tech stack & Open-source libraries

- Minimum SDK level 23
- 100% Kotlin
- 使用 Koin 進行 injection
- 使用 Navigation
- 遵從 Git Flow 原則
- Jetpack
  - Lifecycle
  - Livedata
  - ViewModel
  - DataBinding
- 使用 Coroutines & Flow 處理 API 及 Sort switch
- 使用 Airbnb Lottie 處理 Loading 動畫
- 使用 Moshi 解析 Json
