* 운영 SETTING * WINDOWS 기준
-- 팀과제 / 개인과제 모두 루트계정 하위에 IAM 계정을 제공한다고 합니다. 
따라서 IAM 계정이 생성되었다고 가정하고 그 이후의 상황을 정리합니다. 

1. 로컬 윈도우에 우분투설치 (Microsoft 스토어에 윈도우용 우분투 설치) 
<참고 - 우분투 패키지 관리 툴> http://taewan.kim/tip/apt-apt-get/ 

2. 우분투에 mvn 설치 (환경변수 세팅은 msaschool 참고)

sudo apt-get install maven

3. 우분투에 Kubectl 설치

<참고 - 공식문서> https://kubernetes.io/ko/docs/tasks/tools/install-kubectl-linux/ 

4. 우분투에 AWS CLI 설치

<참고 - 공식문서> https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/install-cliv2-linux.html

curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"

-- UNZIP을 위해서는 위 1번에서 UNZIP 관련 PACKAGE 설치가 되어있어야 함.
sudo apt install unzip

unzip awscliv2.zip

sudo ./aws/install

설치 후에 aws --version 로 설치여부 확인

5. AWS CONFIGURE 를 위한 사전작업
<참고> https://blog.naver.com/isc0304/222325840683
       https://blog.naver.com/kgg1959/222193376777

1) 액세스키 획득을 위해서는 IAM 계정으로 감
-- IAM 계정 생성 방법 
<참고> https://blog.naver.com/dsz08082/222387462598


2) 사용자에서 본인 ID 선택 --> 보안 자격 증명
3) 액세스 키 만들고 메모장에 따로 저장 
EX. 실행예시

vbaorov@LAPTOP-MFPRU95A:~$ aws configure
AWS Access Key ID [None]: AKIAZPKSFUUGGTEQYQVM
AWS Secret Access Key [None]: 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
Default region name [None]: ap-northeast-2
Default output format [None]: json


6. 우분투에 EKS 설치 

curl --location "https://github.com/weaveworks/eksctl/releases/download/latest_release/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
설치 확인
eksctl version

7. 우분투에서 eksctl 명령어로 클러스터 구성 (시간 좀 걸림)

eksctl create cluster --name (vbaorov-eks) --version (1.18) --nodegroup-name standard-workers --node-type t3.medium --nodes 2 --nodes-min 1 --nodes-max 2

8. ECR 구성
<참고> https://blog.naver.com/sssang97/222459232906 

-- 작성중
