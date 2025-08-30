# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## プロジェクト概要

このリポジトリは、Kotlinで代表的なアルゴリズムを実装してまとめるためのプロジェクトです。

## 開発環境

- **言語**: Kotlin（最新LTSバージョンを使用）
- **ビルドツール**: Gradle
- **コーディング規約**: Kotlin公式コーディング規約に準拠

## プロジェクト構造

## 開発方針

- Kotlin公式コーディング規約に厳密に従うこと
- 各アルゴリズムは独立したクラスまたはファイルとして実装
- main関数を持つ実行可能なサンプルコードを含める
- 適切な単体テストを併記すること
- コメントは日本語で記述

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
- 最低カバレッジ: 80%