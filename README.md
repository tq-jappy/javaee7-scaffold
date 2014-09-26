javaee7-sandbox
===============

小さく始められるJava EE 7のScaffold。

- Java: Java SE 8/Java EE 7
- IDE: Eclipse (4.4)
- ビルド: Gradle (2.1)
- Application Server: Wildfly (8.1.0.Final)
- 結合テスト: Arquillian (1.1.5.Final)

## 準備

### 管理用ユーザの作成

```
# cd {wildfly_home}
# ./add-user -u admin -p password -sc {wildfly_home}/standalone/configuration
```

## 注意点

Full ProfileでないとJMS等が使えないので、設定は ``standalone.xml`` ではなく、 ``standalone-full.xml`` の方を使う(build.gradle, arquillian.xml 等)

## ビルド

```
./gradlew war
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
