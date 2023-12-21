package org.labeli.swift

/** Une class qui permet de représenter un Result d'une opération. */
public sealed class Result<out Success, out Failure> where Failure: Throwable {
    /** Savoir si on est dans le cas d'un success. */
    internal abstract fun isSuccess(): Boolean
    /** Savoir si on est dans le cas d'une erreur */
    internal abstract fun isFailure(): Boolean

    /** La class qui représente la donnée en cas de success. */
    public class Success<out S>(val value: S): Result<S, Nothing>() {
        public override fun isSuccess() = true
        public override fun isFailure() = false
    }
    /** La classe qui contient la donnée en cas d'erreur. */
    public class Failure<out E>(val error: E): Result<Nothing, E>() where E: Throwable {
        public override fun isSuccess() = false
        public override fun isFailure() = true
    }

    companion object {
        /** Génère un success. */
        public fun <S>success(value: S): Result<S, Nothing> = Success(value)
        /** Génère une erreur. */
        public fun <E>failure(error: E): Result<Nothing, E> where E: Throwable = Failure(error)
    }

    /** Définit une action dans le cas d'un success. */
    public inline fun onSuccess(action: (Success) -> Unit) {
        if (this is Result.Success) action(value)
    }
    /** Définit une action dans le cas d'une erreur. */
    public inline fun onFailure(action: (Failure) -> Unit) {
        if (this is Result.Failure) action(error)
    }
    /** Définit l'action en cas d'erreur ET de success. */
    public inline fun onBoth(onSuccess: (Success) -> Unit, onFailure: (Failure) -> Unit) {
        when (this) {
            is Result.Success -> onSuccess(value)
            is Result.Failure -> onFailure(error)
        }
    }
    /** Dans le cas d'un success, transforme la donnée contenue dans success en T sinon on continue de renvoyer l'erreur. */
    public fun <T>map(transform: (Success) -> T): Result<T, Failure> {
        return when (this) {
            is Result.Success -> success(transform(value))
            is Result.Failure -> this
        }
    }
}
