javaee7-sandbox
===============

小さく始められるJava EE 7のScaffold。

- IDE: Eclipse
- ビルド: Gradle
- Application Server: Wildfly
- 結合テスト: Arquillian

## 準備

## 管理用ユーザの作成

```
# cd {wildfly_home}
# ./add-user -u admin -p password -sc {wildfly_home}/standalone/configuration
```

## その他ポイント

- JBoss Toolsを使う場合、サーバの設定で適用する設定ファイルは standalone.xml ではなく、standalone-full.xml とする(Full ProfileでないとJMS等が使えない)。
 - Eclipseからサーバを起動する場合はサーバの設定を確認。
 - デプロイスクリプトやarquillian.xmlも影響。

## ビルド

```
./gradlew war
```

## デプロイ

[gradle-cargo-plugin](https://github.com/bmuschko/gradle-cargo-plugin)を利用。

### ローカル

```
./gradlew cargoRunLocal
```

または

```
./gradlew cargoStartLocal
```

``cargoRunLocal`` の場合は、 ``Ctrl+c`` で停止する。
``cargoStartLocal`` の場合は ``cargoStopLocal`` タスクで停止する。

ホットデプロイは不可なので、アプリを更新したら、再起動が必要。

### リモート（ホットデプロイ可）

事前にコンテナ(Wildfly)を起動させておいて、

```
./gradlew cargoDeployRemote
```

と

```
./gradlew cargoRedeployRemote
```

## 動作確認

http://localhost:8080/javaee7-sandbox/api/hello/world にアクセスして "Hello, world!" と表示されればOK。URL の world の部分を変えればレスポンスも変わる。
