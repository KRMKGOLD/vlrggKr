# vlrggKr (Unoffical)

> Valorant 대회 전적 사이트 vlr.gg를 크롤링 만든 Android Application

[노션 링크](https://yielding-cork-c2a.notion.site/vlrgg-android-3887972d0b404d569bb9b82f0ac5072c)

## Project Structure

기초적인 패키지 구조는 [android/nowinandroid](https://github.com/android/nowinandroid/blob/main/docs/ArchitectureLearningJourney.md) 를 기반으로 합니다.
nowinandroid 부분은 domain 레이어가 존재하지만, jsoup을 이용하는 경우 웹 사이트에 노출시킬 때 이미 세분화 되어 있는 데이터를 이용합니다.
따라서 해당 프로젝트에서는 domain 레이어가 큰 필요성이 없다고 판단, 해당 부분을 제거했습니다.

1. App Module
- App Module은 One Activity Screen을 위한 Main 화면과 Nav 관련 코드들, Compose Theme 코드, Android App 빌드를 위한 메인 모듈입니다.
2. Core Module
- Core Module은 서버 통신 부분 로직 (및 디자인시스템) 을 위한 모듈입니다.
3. Feature Module
- Feature Module은 App Module에 있는 MainActivity(One Activity) 를 위한 모듈로, 화면 개발에 대해서는 해당 모듈에서 담당합니다.

## Git Flow

간단한 개인 프로젝트이자 배포에 목적을 두지 않고 있는 프로젝트입니다.
따라서 develop 브랜치의 역할을 main 브랜치에 이관하고 각 화면 개발을 깃허브 이슈로 생성, 각 이슈에 대해서 feature 브랜치를 생성해 개발합니다.
![image](https://user-images.githubusercontent.com/37148833/213862783-b5379544-9112-4829-aa80-f67e1b7fb2af.png)
