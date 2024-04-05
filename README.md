# 👨‍💻프로젝트 제목
    나인라이프(9-life) : 9조가 좋아하는 아이돌들에 대한 게시물을 볼 수 있는 간단한 SNS 앱 

<br>
    
# 🤔프로젝트 정보 및 소개
##### V Live 앱의 UI를 모티브로 하여 9조 팀원들이 각자 좋아하는 아이돌들의 일상 및 정보를 볼 수 있는 간단한 SNS 앱입니다.  
##### 앱에는 다음과 같은 기능들이 있습니다.
###### 1. 메인 화면에서 아이돌들에 대한 여러가지 정보를 스크롤을 통해 확인할 수 있다.
###### 2. 상단 수평 스크롤바에서는 아이돌 아이콘을 클릭하면 그와 관련된 정보를 살펴볼 수 있다.
###### 3. 하단 수직 스크롤바에서 게시물을 클릭하면 상세 페이지를 확인할 수 있다.
###### 4. 상단의 사람 아이콘을 클릭하면 로그인과 회원가입 창으로 넘어갈 수 있다.
###### 5. 회원가입 기능을 통해 나만의 아이디와 비밀번호를 생성할 수 있다.
###### 6. 마이페이지에서 내 정보를 확인할 수 있고 내가 좋아하는 아티스트명을 정할 수 있다.  

<br>

# ⌚개발 기간
    2024.04.01(월) - 2024.04.05(금) 총 5일

<br>

# ⚙️서비스 전체 기능
- ViewBinding
- Fragment
- RecyclerView
- Adapter
- ViewHolder
- TextWatcher
- Regex Pattern
- Animation
- 영어 모드 지원
- 동그란 ImageView
- scroll 기능
- 더보기 기능
- Font 글씨 크기 조절 기능
- 다크모드
- 세로/가로 모드 
<br>

# 📄 페이지 UI / 기능 소개

- **앱 실행 시 첫 화면 (HomeFragment)**

    상단의 아이돌 프로필들은 가로로 스크롤이 가능하고 하단의 게시글들은 세로로 스크롤이 가능하다. 이 화면에서 프로필 모양을 클릭하       면 로그인, 회원가입 창(FirstActivity)으로 넘어간다.

<p align="center">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/cbda25d6-2e77-4422-9253-1ca614550594">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/7d78fc05-9abe-4090-91f5-11a64865476f">
</p>

---

- **로그인 버튼과 회원가입 버튼을 클릭했을 경우 (LoginActivity, SignupActivity)**

  로그인 버튼을 클릭하면 LoginActivity 로 넘어가게 되고, 회원가입 버튼을 클릭하면 SignupActivity 로 넘어가게 되며 회원가입을 할때 이메일과 비밀번호의 실시간 유효성 검사 기능이 추가되어 있다.
<p align="center">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/7a13b809-1dc2-4700-8a74-8a9678d0c5cd">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/91682dc8-fdc9-433c-a12d-4a3c4cf3411d">
</p>


---

- **상단 프래그먼트 (아이돌 프로필) 클릭했을 경우 (Bts,Btob,Idle - Activity)**

  상단 프래그먼트를 클릭하면 해당 아이돌에 대한 설명과 로고가 담긴 창으로 넘어가게 된다.
<p align="center">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/1428ad21-263f-4363-965c-3ee9885aa8cf">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/bb1b323c-650f-40ac-8e62-cb74750e34e3">
</p>

---

- **하단 프래그먼트 (아이돌 게시글) 클릭했을 경우 (DetailActivity)**

  홈 프래그먼트 창의 게시글 이미지, 글 제목, 글 내용이 DetailActivity 로 전달된 것을 확인할 수 있다. 글 내용의 길이가 두 줄 이상일 경우에 더보기(more) 를 클릭하면 내용을 마저 볼 수 있고 다시 접을 수도 있다. 

<p align="center">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/957cfb66-7ba4-45a9-9e9f-2275f24fd174">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/3b97f0dd-0aa4-406f-a906-40847e16272a">
</p>


---

- **홈 프래그먼트의 하단 바 메뉴 중 마이페이지를 클릭했을 경우 (MypageActivity)**

  마이페이지 창에서는 내가 좋아하는 아티스트를 추가할 수 있고 회원가입 후 로그인을 한 뒤 마이페이지로 이동하면 로그인/회원가입 때 입력했던 정보들이 마이페이지에 넘어가서 출력되게 한다.

<p align="center">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/42a25324-07f3-4bae-bddb-12798b503e4c">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/57991bcc-caa0-4dc3-a6d8-a86b793d16c1">
</p>

  ---

 - **회원가입 후 로그인을 한 뒤 다시 마이페이지로 돌아왔을 때 정보가 전달된 경우 (HomeFragment, MypageActivity)**

   로그인을 한 뒤에는 홈 화면 상단에도 유저의 정보에 따라서 안녕하세요 000님이 출력되고 마이페이지로 넘어갔을 때도 이름과 계정 정보가 전달된 것을 확인할 수 있다.

<p align="center">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/a47d1cc1-7894-4e42-8631-3589baae4668">
    <img src="https://github.com/wndnjs00/week3_sns_project/assets/128487386/eec01cb5-e864-4b58-8b35-f436262924fa">

<br>


# 🤝팀소개 및 각자 맡은 역할
###### 저희는 성희영 튜터님도 인정해주시는 귀염뽀짝한 9조입니다😁
<p align="center">
    <img src="https://github.com/wndnjs00/week3_sns_project/blob/dev/bootcamp_9.png" height="400dp" width="400dp">
</p>


### 👨🏻‍💻정경우
- 로그인, 회원가입 페이지 구현 (브랜치 이름: login)
- 액티비티 전환 시 애니메이션 구현
- 더보기 기능 추가
- detail 페이지에서 영문일때 글자 잘리는 문제 수정
- 스트링 추가, 영어 타이틀
### 👩🏻‍💻전주원
- 홈 메인 페이지 (브랜치 이름: home)
- 깃허브에서 merge한 액티비티 연결하기
- recyclerView 구현하기
- 동그란 ImageView 만들기
- 가로모드 ui 구현
- MainActivity까지 넘긴 데이터를 MyFragment로 넘기기
- My artist 부분 데이터 넣기
- 마이페이지에 스피너 추가
### 👨🏻‍💻변예진
- 디테일 세부사항 페이지 (브랜치 이름: detail)
- 필수 구현 영어 버전 변경 적용하기
- Font 크기 설정에 따라 글씨 크기 달라지도록 구현
- 영문 버전에서도 Toast 메세지가 영어로 뜨게 수정
- 상단 아이돌 창을 클릭했을때 세부 상태를 보여주는 액티비티 3개 생성
- 이메일 유효성 검사
### 👩🏻‍💻박세영
- 마이페이지 (브랜치 이름: mypage)
- 인텐트로 프로퍼티 연결해보기
- Dark theme 구현
- 회원 정보 관리 구현
- MainActivity를 처음 화면으로 옮기고, 상단에 레이아웃 새로 생성해서 로그인/회원가입 페이지로 넘어갈 수 있게 액티비티 순서 변경하기
- 비밀번호 유효성 검사

<br>

# 🔧 기술 스택
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=android&logoColor=white)
![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)
![Git](https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white)
![Github](https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white)

<br>

# 🔗노션 링크
[첫번째 프로젝트 9조 노션](https://www.notion.so/teamsparta/9-a1fc0aee0cbd4249b95b294b0eccdcf3)

<br>

# 🔗유튜브 링크 (프로젝트 실행 영상)
[9조 프로젝트 실행 영상 (1)](https://www.youtube.com/watch?v=cOJgKMQnH_c)
<br>
[9조 프로젝트 실행 영상 (2)](https://www.youtube.com/watch?v=LKiKZyAVXqI)

