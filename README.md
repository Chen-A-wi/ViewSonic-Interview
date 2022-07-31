# ViewSonic-Interview
此專案主要是For ViewSonic的小作業，實作SpaceX發射資料，下面是Demo畫面👇。

// TODO: Need to change demo image.

| Loading  | Result |
| ------------- | ------------- |
|<img src= "https://user-images.githubusercontent.com/24693300/171027104-22be08de-ba1e-4da1-ba6e-fb3502fa4b66.png" width="360" height="720" /> | <img src= "https://user-images.githubusercontent.com/24693300/171027471-d4f5abf1-e639-4881-9d16-8af040770090.png" width="360" height="720" />  |

| API Error | No Internet |
| ------------- | ------------- |
| <img src= "https://user-images.githubusercontent.com/24693300/171027764-a2eb623d-8738-410d-b18e-659943ee7051.png" width="360" height="720" /> | <img src= "https://user-images.githubusercontent.com/24693300/171028860-e2b7a5de-3d59-4d24-9fed-207c54c64af9.png" width="360" height="720" />  |

| Search enter space |
| ------------- |
| <img src= "https://user-images.githubusercontent.com/24693300/171076492-2a6c0567-7852-4c15-92b8-b54a668608de.png" width="360" height="720" /> | 

## Feature List
- [x] 使用Kotlin以及AndroidArchitectureComponent的元件。
- [x] 以MVVM為架構設計。
- [x] 使用RecyclerView實作清單列表。
- [x] 點擊Flightnumber:oldest跳出排序選項。
- [x] 列表可依FlightNumber排序(大到小/小到大)。
- [x] 點擊清單可進入LaunchDetail頁面。
- [x] 使用Fragment實作LaunchDetail頁面。
- [x] 專案完成後請上傳到GitHub或者GitLab。

### Bonus
- [x] 以CleanCode思維來實作專案。
- [ ] UnitTestandUItest(Espresso)。

## Tech stack & Open-source libraries

- Minimum SDK level 23
- 100% Kotlin
- 使用Koin進行injection
- 使用Navigation
- 遵從Git Flow原則
- Jetpack
  - Lifecycle
  - Livedata
  - ViewModel
  - DataBinding
- 使用Coroutines & Flow處理API
- 使用Airbnb Lottie處理Loading動畫
- 使用Moshi解析Json
