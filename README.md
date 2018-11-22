# ipf-gradle-plugin
Gradle plugin for building an ipf file.

## これはなに
ipfファイルを作成するためのGradleプラグインです.

## 使い方

### 前提
```bash
ipf [ファイル名] [圧縮するディレクトリ]
```
の形式でipfを作成するコマンドがインストールされている必要があります.

私の環境では下記を使用させて頂いています（公開ありがとうございます）.
* [analysisjp/libipf: Tree of savior ipf pack/unpack library](https://github.com/analysisjp/libipf)

### プロジェクトへの適用

1. releaseページからgradle-ipf-plugin-X.X.X.jarをダウンロードし、プロジェクトフォルダから到達可能な場所に格納してください.
2. プロジェクトフォルダ内のbuild.gradleに下記のような感じで設定してください.
```gradle
/*
 * build.gradle
 */
apply plugin: com.github.tokageel.ipf.IpfPlugin

addon {
    // ipfファイル名とファイル内のディレクトリ構造に使用されるアドオン名.
    // 未設定の場合、${project.name}が使用されます.
    name "myaddon"
    // ipfファイル名に使用するバージョン名.
    // 未設定の場合、${project.version}が使用されます.
    version "0.0.1"
    // ipfファイルに付与するUnicode文字.
    // 未設定の場合、"🦎"が使用されます.
    unicode "😊"
    // ソースの格納場所.
    // 未設定の場合、"src"が使用されます.
    sourceDir "src"
}

buildscript {
    dependencies {
        // ダウンロードしたjarファイルへのパスを設定してください.
        // X.X.Xはダウンロードしたjarファイルに合わせてください.
        classpath files('../gradle-ipf-plugin-X.X.X.jar')
    }
}
```
3. `gradle build`を実行すると、*build/_myaddon-😊-v0.0.1.ipf*が生成されます.

## 制限等

* 現状、macOS (10.14.1 Mojave)でのみ動作を確認しています.
