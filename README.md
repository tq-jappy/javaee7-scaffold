javaee7-scaffold
===============

小さく始められるJava EE 7のScaffold。

- Java: Java SE 8/Java EE 7
- IDE: Eclipse (4.4)
- ビルド: Gradle (2.1)
- Application Server: Wildfly (8.1.0.Final)
- 結合テスト: Arquillian (1.1.5.Final)

## 準備

### Wildflyのインストール

パッケージ ( http://download.jboss.org/wildfly/8.1.0.Final/wildfly-8.1.0.Final.tar.gz )をダウンロードして展開する。

### 環境変数の設定

最低限以下をセットしておく。

- ``JAVA_HOME``
- ``JBOSS_HOME``

### このリポジトリをClone


### Eclipseへのプロジェクトのインポート

[File] - [Import] - [Gradle Project]

### ※ Proxy環境の場合の設定

``gradle.properties`` をこのディレクトリかユーザホームディレクトリに置いておき、以下のように記述（値は環境に合わせる）。

```
systemProp.http.proxyHost=yourproxy
systemProp.http.proxyPort=8080
systemProp.https.proxyHost=yourproxy
systemProp.https.proxyPort=8080
```

### 管理用ユーザの作成

```
# cd {wildfly_home}
# ./add-user.sh -u {username} -p {password} -sc {wildfly_home}/standalone/configuration
```

後述のデプロイタスクにおいて、リモートコンテナにデプロイするためにはユーザ名とパスワードが必須なので、この準備はMUST。

それ以外の場合は、任意（ただし、Wildfly を使う上で管理コンソールは便利なので、登録しておいた方が良い）

## ビルド

```
./gradlew war
```

## テスト

```
./gradlew test
```

## デプロイ

[gradle-cargo-plugin](https://github.com/bmuschko/gradle-cargo-plugin)を使って Gradle タスクとしてデプロイする。

### ローカル

```
./gradlew cargoRunLocal
```

または

```
./gradlew cargoStartLocal
```

``cargoRunLocal`` の場合は、 ``Ctrl+c`` で停止。
``cargoStartLocal`` の場合は ``cargoStopLocal`` タスクで停止。

ホットデプロイは不可なので、アプリを更新したら、再起動が必要。

### リモート（ホットデプロイ可）

事前にコンテナ(Wildfly)を起動させておいて、

```
./gradlew cargoDeployRemote
```

```
./gradlew cargoRedeployRemote
```

## 動作確認

http://localhost:8080/javaee7-sandbox/api/hello/world にアクセスして "Hello, world!" と表示されればOK。URL の world の部分はパスパラメータなので、別の文字列にすれば表示される文字列も変化する。
