# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## プロジェクト概要

このリポジトリは、Kotlinで代表的なアルゴリズムを実装してまとめるためのプロジェクトです。

## 開発環境

- **言語**: Kotlin 2.2.10
- **JVM**: Java 21
- **ビルドツール**: Gradle (Kotlin DSL)
- **テストフレームワーク**: JUnit 5 (5.11.3)
- **アサーションライブラリ**: AssertJ (3.26.3)
- **カバレッジ**: JaCoCo (最低80%)
- **コーディング規約**: Kotlin公式コーディング規約に準拠

## プロジェクト構造

```
src/main/kotlin/com/algorithm/
  ├── <category>/          # アルゴリズムカテゴリごとのパッケージ
  │   └── <Algorithm>.kt   # 1ファイル1クラス
  └── Main.kt
src/test/kotlin/com/algorithm/
  └── <category>/
      └── <Algorithm>Test.kt
```

カテゴリ例: `sort`, `recursion`, `binarysearch`, `bruteforce`, `dynamicprogramming`, `greedy`

## ビルドとテスト

### Gradleコマンド
- ビルド: `./gradlew build`
- テスト実行: `./gradlew test`
- 単一テスト: `./gradlew test --tests "ClassName"`
- クリーンビルド: `./gradlew clean build`
- カバレッジレポート生成: `./gradlew test jacocoTestReport`
- カバレッジ検証: `./gradlew jacocoTestCoverageVerification`

### カバレッジレポート
- HTMLレポート: `build/reports/jacoco/test/html/index.html`
- XMLレポート: `build/reports/jacoco/test/jacocoTestReport.xml`
- 最低カバレッジ: 80%（Main.ktは除外）

## コーディング規約

### ソースコード

- Kotlin公式コーディング規約に厳密に従うこと
- 各アルゴリズムは独立したクラスとして1ファイル1クラスで実装
- main関数を持つ実行可能なサンプルコードを含める
- コメント・KDocは日本語で記述
- 入力バリデーションは`require()`を使用し、エラーメッセージは日本語

### KDocの書き方

クラスレベル:
```kotlin
/**
 * アルゴリズムの説明
 * 時間計算量: O(n²)
 * 空間計算量: O(1)
 */
```

メソッドレベル:
```kotlin
/**
 * 書籍の節番号 メソッドの説明タイトル
 *
 * 詳細な説明
 * @param パラメータ名 説明
 * @return 戻り値の説明
 * @throws IllegalArgumentException 例外条件の説明
 */
```

### テストコード

- テストクラス名: `<対象クラス名>Test`
- クラスレベルの`@DisplayName`: 日本語でアルゴリズム名（例: `@DisplayName("バブルソート")`）
- メソッドレベルの`@DisplayName`: 日本語で「〜こと」形式（例: `@DisplayName("空の配列をソートできること")`）
- 関数名: テスト内容に合った英語名（例: `fun sortEmptyArray()`）
- `@BeforeEach`の`setUp()`でテスト対象クラスを初期化（`private lateinit var`を使用）
- 関連するテストは`@Nested` inner classでグループ化
- アサーションはAssertJを使用（`assertThat`, `assertThatThrownBy`）
- テストメソッド内は`// Given`, `// When`, `// Then`コメントで構造化
- エッジケース（空配列、単一要素、負の数、境界値）を網羅すること
